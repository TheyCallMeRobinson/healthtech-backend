CREATE SEQUENCE timetables_id_seq;
ALTER SEQUENCE timetables_id_seq
    MINVALUE 3
        RESTART 3
        START 3;
ALTER TABLE healthtech.time_records
    ALTER COLUMN id SET DEFAULT nextval('timetables_id_seq');