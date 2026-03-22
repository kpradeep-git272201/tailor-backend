-- Create cart table in tailor schema
CREATE TABLE IF NOT EXISTS tailor.cart (
    cart_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    article_id BIGINT,
    fabric_id BIGINT,
    quantity INTEGER NOT NULL DEFAULT 1,
    price DECIMAL(10, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create index for faster lookups by user_id
CREATE INDEX IF NOT EXISTS idx_cart_user_id ON tailor.cart(user_id);
