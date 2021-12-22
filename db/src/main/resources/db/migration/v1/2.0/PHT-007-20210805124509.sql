CREATE TABLE healthtech.roles
(
    role_id INTEGER PRIMARY KEY,
    name    varchar(30) UNIQUE
);

INSERT INTO healthtech.roles
VALUES (1, 'ADMIN'),
       (2, 'DOCTOR'),
       (3, 'PATIENT');

ALTER TABLE healthtech.users
    ADD COLUMN role_id INTEGER NOT NULL DEFAULT 3 REFERENCES healthtech.roles (role_id);
