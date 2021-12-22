DROP SEQUENCE id_time_records CASCADE;
ALTER TABLE healthtech.time_records
    ALTER COLUMN id DROP DEFAULT;