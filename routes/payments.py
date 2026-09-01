from flask import Blueprint, jsonify
import store

payments_bp = Blueprint("payments", __name__)


@payments_bp.get("/payments")
def list_payments():
    return jsonify(list(store.payments.values()))
