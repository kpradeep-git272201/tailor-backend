-- Create measurements table in tailor schema
CREATE TABLE IF NOT EXISTS tailor.measurements (
    measurement_id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    article_id BIGINT,
    measurement_name VARCHAR(100),
    chest DECIMAL(5, 2),
    waist DECIMAL(5, 2),
    hip DECIMAL(5, 2),
    shoulder DECIMAL(5, 2),
    sleeve_length DECIMAL(5, 2),
    shirt_length DECIMAL(5, 2),
    neck DECIMAL(5, 2),
    inseam DECIMAL(5, 2),
    outseam DECIMAL(5, 2),
    thigh DECIMAL(5, 2),
    calf DECIMAL(5, 2),
    ankle DECIMAL(5, 2),
    unit VARCHAR(10) DEFAULT 'cm',
    notes TEXT,
    is_default BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes
CREATE INDEX IF NOT EXISTS idx_measurements_user_id ON tailor.measurements(user_id);
CREATE INDEX IF NOT EXISTS idx_measurements_user_default ON tailor.measurements(user_id, is_default);
