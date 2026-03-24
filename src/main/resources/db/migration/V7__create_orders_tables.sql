-- Create orders table in tailor schema
CREATE TABLE IF NOT EXISTS tailor.orders (
    order_id BIGSERIAL PRIMARY KEY,
    booking_id BIGINT,
    user_id BIGINT NOT NULL,
    order_number VARCHAR(50) UNIQUE NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    total_amount DECIMAL(10, 2),
    payment_status VARCHAR(20) DEFAULT 'PENDING',
    delivery_address_id BIGINT,
    estimated_delivery_date TIMESTAMP,
    actual_delivery_date TIMESTAMP,
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create order_items table
CREATE TABLE IF NOT EXISTS tailor.order_items (
    order_item_id BIGSERIAL PRIMARY KEY,
    order_id BIGINT NOT NULL,
    article_id BIGINT,
    fabric_id BIGINT,
    measurement_id BIGINT,
    quantity INTEGER NOT NULL DEFAULT 1,
    price DECIMAL(10, 2),
    subtotal DECIMAL(10, 2),
    status VARCHAR(20) DEFAULT 'PENDING'
);

-- Create indexes
CREATE INDEX IF NOT EXISTS idx_orders_user_id ON tailor.orders(user_id);
CREATE INDEX IF NOT EXISTS idx_orders_order_number ON tailor.orders(order_number);
CREATE INDEX IF NOT EXISTS idx_orders_status ON tailor.orders(status);
CREATE INDEX IF NOT EXISTS idx_orders_booking_id ON tailor.orders(booking_id);
CREATE INDEX IF NOT EXISTS idx_order_items_order_id ON tailor.order_items(order_id);
