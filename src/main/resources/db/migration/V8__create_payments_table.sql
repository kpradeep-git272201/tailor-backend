-- Create payments table in tailor schema
CREATE TABLE IF NOT EXISTS tailor.payments (
    payment_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    payment_gateway VARCHAR(50),
    transaction_id VARCHAR(100) UNIQUE,
    amount DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(10) DEFAULT 'INR',
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    payment_method VARCHAR(50),
    gateway_order_id VARCHAR(100),
    gateway_payment_id VARCHAR(100),
    gateway_signature VARCHAR(255),
    failure_reason TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completed_at TIMESTAMP
);

-- Create indexes
CREATE INDEX IF NOT EXISTS idx_payments_order_id ON tailor.payments(order_id);
CREATE INDEX IF NOT EXISTS idx_payments_user_id ON tailor.payments(user_id);
CREATE INDEX IF NOT EXISTS idx_payments_transaction_id ON tailor.payments(transaction_id);
CREATE INDEX IF NOT EXISTS idx_payments_gateway_order_id ON tailor.payments(gateway_order_id);
CREATE INDEX IF NOT EXISTS idx_payments_status ON tailor.payments(status);
