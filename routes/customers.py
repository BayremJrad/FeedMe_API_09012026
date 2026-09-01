from flask import Blueprint, jsonify, request, abort
from datetime import datetime
import uuid
import store

customers_bp = Blueprint("customers", __name__)


@customers_bp.post("/customers")
def create_customer():
    body = request.get_json(silent=True) or {}
    name, email = body.get("name"), body.get("email")
    if not name or not email:
        abort(400, "name and email are required")

    cid = f"cust_{uuid.uuid4().hex[:6]}"
    customer = {
        "id": cid,
        "name": name,
        "email": email,
        "createdAt": datetime.utcnow().strftime("%Y-%m-%dT%H:%M:%SZ"),
    }
    store.customers[cid] = customer
    return jsonify(customer), 201


@customers_bp.get("/customers")
def list_customers():
    return jsonify(list(store.customers.values()))
