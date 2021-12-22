ALTER TABLE healthtech.patients
    DROP COLUMN age,
    ADD COLUMN birthdate DATE NOT NULL DEFAULT '1970-01-01'
;