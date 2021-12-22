ALTER TABLE healthtech.time_records
    ALTER COLUMN start_time TYPE TIMESTAMP USING start_time::timestamp without time zone,
    ALTER COLUMN end_time TYPE TIMESTAMP USING start_time::timestamp without time zone,
    ALTER COLUMN start_time SET DEFAULT CURRENT_TIMESTAMP,
    ALTER COLUMN end_time SET DEFAULT CURRENT_TIMESTAMP,
    DROP COLUMN date;
