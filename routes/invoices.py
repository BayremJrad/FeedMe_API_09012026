from flask import Blueprint, jsonify, request, abort
from datetime import date
import uuid
import store

invoices_bp = Blueprint("invoices", __name__)

SUMMARY_KEYS = ("id", "customerId", "invoiceNumber", "currency", "total", "status")


def _total(line_items):
    return sum(i.get("quantity", 0) * i.get("unitPrice", 0) for i in line_items)


def _status(total, paid):
    if paid == 0:
        return "open"
    return "paid" if paid >= total else "partially_paid"


@invoices_bp.post("/invoices")
def create_invoice():
    body = request.get_json(silent=True) or {}
    if not body.get("customerId"):
        abort(400, "customerId is required")

    line_items = body.get("lineItems", [])
    total = _total(line_items)
    iid = f"inv_{uuid.uuid4().hex[:6]}"
    today = date.today().isoformat()

    invoice = {
        "id": iid,
        "invoiceNumber": f"INV-{len(store.invoices) + 1001}",
        "customerId": body["customerId"],
        "invoiceDate": body.get("invoiceDate", today),
        "dueDate": body.get("dueDate", today),
        "currency": body.get("currency", "USD"),
        "lineItems": line_items,
        "total": total,
        "amountPaid": 0,
        "balanceDue": total,
        "status": "open",
    }
    store.invoices[iid] = invoice
    return jsonify({k: invoice[k] for k in SUMMARY_KEYS}), 201


@invoices_bp.get("/invoices")
def list_invoices():
    return jsonify([{k: inv[k] for k in SUMMARY_KEYS} for inv in store.invoices.values()])


@invoices_bp.get("/invoices/<invoice_id>")
def get_invoice(invoice_id):
    inv = store.invoices.get(invoice_id)
    if not inv:
        abort(404, f"Invoice {invoice_id} not found")
    return jsonify(inv)


@invoices_bp.post("/invoices/<invoice_id>/payments")
def record_payment(invoice_id):
    inv = store.invoices.get(invoice_id)
    if not inv:
        abort(404, f"Invoice {invoice_id} not found")

    body = request.get_json(silent=True) or {}
    amount = body.get("amount", 0)
    if amount <= 0:
        abort(400, "amount must be a positive integer")

    pid = f"pay_{uuid.uuid4().hex[:6]}"
    payment = {
        "id": pid,
        "invoiceId": invoice_id,
        "amount": amount,
        "currency": inv["currency"],
        "paymentDate": body.get("paymentDate", date.today().isoformat()),
        "method": body.get("method", "bank_transfer"),
        "reference": body.get("reference", ""),
    }
    store.payments[pid] = payment

    inv["amountPaid"] += amount
    inv["balanceDue"] = max(0, inv["total"] - inv["amountPaid"])
    inv["status"] = _status(inv["total"], inv["amountPaid"])

    return jsonify(payment), 201
