from flask import Flask, jsonify
from routes.health import health_bp
from routes.customers import customers_bp
from routes.invoices import invoices_bp
from routes.payments import payments_bp

app = Flask(__name__)

app.register_blueprint(health_bp)
app.register_blueprint(customers_bp)
app.register_blueprint(invoices_bp)
app.register_blueprint(payments_bp)


@app.errorhandler(400)
def bad_request(e):
    return jsonify({"error": str(e)}), 400


@app.errorhandler(404)
def not_found(e):
    return jsonify({"error": str(e)}), 404


if __name__ == "__main__":
    app.run(debug=True, port=3000)

