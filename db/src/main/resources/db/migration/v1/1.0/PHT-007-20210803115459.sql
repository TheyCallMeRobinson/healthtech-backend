ALTER TABLE healthtech.comments
    ALTER COLUMN patient_id SET NOT NULL,
    ALTER COLUMN doctor_id SET NOT NULL;