CREATE SCHEMA healthtech;

CREATE TABLE healthtech.users
(
    id         SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    mid_name   VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    password   VARCHAR(50) NOT NULL
);

CREATE TABLE healthtech.administrators
(
    id INTEGER PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES healthtech.users (id) ON DELETE CASCADE
    -- прописать privileges
);

CREATE TABLE healthtech.doctors
(
    user_id_ptr INTEGER PRIMARY KEY,
    sex         BOOLEAN,
    rating      FLOAT NOT NULL,
    FOREIGN KEY (user_id_ptr) REFERENCES healthtech.users (id) ON DELETE CASCADE
);

CREATE TABLE healthtech.patients
(
    user_id_ptr INTEGER PRIMARY KEY, -- подумать с неймингом
    age         INTEGER NOT NULL,    -- сменить на birthdate
    sex         CHAR(1) NOT NULL,
    FOREIGN KEY (user_id_ptr) REFERENCES healthtech.users (id) ON DELETE CASCADE
);

CREATE TABLE healthtech.specialities
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE healthtech.allergies
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE healthtech.patients_allergies
(
    patient_id INTEGER REFERENCES healthtech.patients (user_id_ptr),
    allergy_id INTEGER REFERENCES healthtech.allergies (id)
);

CREATE TABLE healthtech.time_records
(
    id         INTEGER PRIMARY KEY,
    doctor_id  INTEGER REFERENCES healthtech.doctors (user_id_ptr),
    date       DATE,
    start_time TIME,
    end_time   TIME
);

CREATE TABLE healthtech.appointments
(
    id             SERIAL PRIMARY KEY,
    patient_id     INTEGER REFERENCES healthtech.patients (user_id_ptr) ON DELETE CASCADE NOT NULL,
    time_record_id INTEGER REFERENCES healthtech.time_records (id) ON DELETE CASCADE      NOT NULL,
    is_taken       BOOLEAN DEFAULT FALSE,
    datetime       TIMESTAMPTZ                                                            NOT NULL
);

CREATE TABLE healthtech.diseases
(
    id         SERIAL PRIMARY KEY,
    patient_id INTEGER REFERENCES healthtech.patients (user_id_ptr),
    name       VARCHAR(100) NOT NULL,
    start_date DATE         NOT NULL,
    end_date   DATE
);

CREATE TABLE healthtech.doctors_specialities
(
    doctor_id     INTEGER REFERENCES healthtech.doctors (user_id_ptr),
    speciality_id INTEGER REFERENCES healthtech.specialities (id),
    receive_date  DATE NOT NULL
);

CREATE TABLE healthtech.comments
(
    id         SERIAL PRIMARY KEY,
    doctor_id  INTEGER REFERENCES healthtech.doctors (user_id_ptr),
    patient_id INTEGER REFERENCES healthtech.patients (user_id_ptr),
    data       DATE    NOT NULL,
    mark       INTEGER NOT NULL,
    comment    VARCHAR(500)
);
/*
ALTER TABLE healthtech.patients
    ADD CONSTRAINT disease_fk FOREIGN KEY (diseases) REFERENCES healthtech.diseases (disease_id);

ALTER TABLE healthtech.patients
    ADD CONSTRAINT appointment_fk FOREIGN KEY (appointments) REFERENCES healthtech.appointments (id);

ALTER TABLE healthtech.doctors
    ADD CONSTRAINT timetable_fk FOREIGN KEY (timetable_id) REFERENCES healthtech.time_records (id);

ALTER TABLE healthtech.appointments
    ADD CONSTRAINT timetable_fk FOREIGN KEY (time_record_id) REFERENCES healthtech.time_records (id);
*/
-- прочитать про inherits
-- контроллеры - принимают и отдают
-- сервисы - бизнес-логика, если бизнес-логики много, в работу включаются facade
-- мапперы - преобразуют модели из одной в другую, у них есть зависимости
-- провайдеры - достают данные откуда-нибудь
-- репозитории привязываются к какому-нибудь хранилищу данных
--

--CREATE SEQUENCE user_seq START 10;
--ALTER TABLE healthtech.user ALTER COLUMN id SET DEFAULT nextval('user_seq');

--*/