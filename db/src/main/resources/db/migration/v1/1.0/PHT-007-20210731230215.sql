ALTER TABLE healthtech.users
    DROP COLUMN first_name,
    DROP COLUMN mid_name,
    DROP COLUMN last_name,
    ADD COLUMN login VARCHAR(100) UNIQUE,
    ADD COLUMN email VARCHAR(100) UNIQUE
;

ALTER TABLE healthtech.doctors
    DROP COLUMN sex,
    ADD COLUMN first_name VARCHAR(100) NOT NULL,
    ADD COLUMN mid_name   VARCHAR(100) NOT NULL,
    ADD COLUMN last_name  VARCHAR(100) NOT NULL
;

ALTER TABLE healthtech.patients
    DROP COLUMN email,
    ADD COLUMN first_name VARCHAR(100) NOT NULL,
    ADD COLUMN mid_name   VARCHAR(100) NOT NULL,
    ADD COLUMN last_name  VARCHAR(100) NOT NULL
;



