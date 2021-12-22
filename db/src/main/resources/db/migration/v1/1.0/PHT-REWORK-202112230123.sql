drop table healthtech.appointments;

drop table healthtech.time_records;

create table healthtech.time_records
(
    id         serial not null
        constraint time_records_pkey
            primary key,
    doctor_id  integer not null
        constraint time_records_doctor_id_fkey
            references healthtech.doctors,
    patient_id integer
        constraint time_records_patient_id_fkey
            references healthtech.patients,
    date       date,
    start_time time,
    result     varchar(50),
    recipe     varchar(500)
);

alter table healthtech.comments
    alter column date type date;