CREATE SEQUENCE id_time_records START 1;

ALTER TABLE healthtech.time_records
    ALTER COLUMN id SET DEFAULT nextval('id_time_records');