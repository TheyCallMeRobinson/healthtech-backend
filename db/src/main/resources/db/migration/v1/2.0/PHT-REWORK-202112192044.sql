create schema ht_fix;

CREATE TABLE ht_fix.roles
(
    role_id integer primary key,
    name    varchar(30) unique
);

insert into ht_fix.roles
values (1, 'ADMIN'),
       (2, 'DOCTOR'),
       (3, 'PATIENT');

create table ht_fix.users
(
    id       serial            not null
        constraint users_pkey primary key,
    password varchar(60)       not null,
    login    varchar(100)
        constraint users_login_key
            unique,
    email    varchar(100)
        constraint users_email_key
            unique,
    role_id  integer default 3 not null
        constraint users_role_id_fkey
            references ht_fix.roles
);

create table ht_fix.administrators
(
    id integer primary key,
    foreign key (id) references ht_fix.users (id) on delete cascade
);

create table ht_fix.doctors
(
    id         integer      not null
        constraint doctors_pkey
            primary key
        constraint doctors_user_id_ptr_fkey
            references ht_fix.users
            on delete cascade,
    first_name varchar(100) not null,
    mid_name   varchar(100) not null,
    last_name  varchar(100) not null
);

create table ht_fix.patients
(
    id           integer                         not null
        constraint patients_pkey
            primary key
        constraint patients_user_id_ptr_fkey
            references ht_fix.users
            on delete cascade,
    sex          char                            not null,
    phone_number varchar(11),
    first_name   varchar(100)                    not null,
    mid_name     varchar(100)                    not null,
    last_name    varchar(100)                    not null,
    birthdate    date default '1970-01-01'::date not null
);

create table ht_fix.allergies
(
    id   serial primary key ,
    name varchar(100) not null
);

create table ht_fix.diseases
(
    id         serial       not null
        constraint diseases_pkey
            primary key,
    patient_id integer      not null
        constraint diseases_patient_id_fkey
            references ht_fix.patients,
    name       varchar(100) not null,
    start_date date         not null,
    end_date   date
);

create table ht_fix.comments
(
    id         serial                              not null
        constraint comments_pkey
            primary key,
    doctor_id  integer
        constraint comments_doctor_id_fkey
            references ht_fix.doctors,
    patient_id integer
        constraint comments_patient_id_fkey
            references patients,
    date       timestamp default CURRENT_TIMESTAMP not null,
    mark       integer                             not null,
    comment    varchar(500)
);

create table ht_fix.specialities
(
    id   serial primary key,
    name varchar(50)
);

create table ht_fix.doctors_specialities
(

    doctor_id     integer not null
        constraint doctors_specialities_doctor_id_fkey
            references ht_fix.doctors,
    speciality_id integer not null
        constraint doctors_specialities_speciality_id_fkey
            references ht_fix.specialities,
    receive_date  date    not null,
    constraint doctors_specialities_pkey
        primary key (doctor_id, speciality_id)
);

create table ht_fix.patients_allergies
(
    patient_id integer
        constraint patients_allergies_patient_id_fkey
            references ht_fix.patients,
    allergy_id integer
        constraint patients_allergies_allergy_id_fkey
            references ht_fix.allergies
);

create table time_records
(
    id         integer default nextval('timetables_id_seq'::regclass) not null
        constraint time_records_pkey
            primary key,
    doctor_id  integer not null
        constraint time_records_doctor_id_fkey
            references ht_fix.doctors,
    patient_id integer
        constraint time_records_patient_id_fkey
            references ht_fix.patients,
    date       date,
    start_time time,
    end_time   time,
    result     varchar(50),
    recipe     varchar(500)
);
