-- Create bookings table in tailor schema
CREATE TABLE IF NOT EXISTS tailor.bookings (
    booking_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    tailor_id BIGINT,
    address_id BIGINT,
    measurement_id BIGINT,
    booking_date DATE NOT NULL,
    booking_time TIME,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    total_amount DECIMAL(10, 2),
    notes TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create booking_items table
CREATE TABLE IF NOT EXISTS tailor.booking_items (
    booking_item_id BIGSERIAL PRIMARY KEY,
    booking_id BIGINT NOT NULL,
    article_id BIGINT,
    fabric_id BIGINT,
    quantity INTEGER NOT NULL DEFAULT 1,
    price DECIMAL(10, 2),
    subtotal DECIMAL(10, 2)
);

-- Create indexes
CREATE INDEX IF NOT EXISTS idx_bookings_user_id ON tailor.bookings(user_id);
CREATE INDEX IF NOT EXISTS idx_bookings_tailor_id ON tailor.bookings(tailor_id);
CREATE INDEX IF NOT EXISTS idx_bookings_status ON tailor.bookings(status);
CREATE INDEX IF NOT EXISTS idx_booking_items_booking_id ON tailor.booking_items(booking_id);
