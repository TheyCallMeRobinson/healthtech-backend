package team.healthtech.db.entity;

import javax.persistence.*;
import java.time.Instant;

@Table(schema = "healthtech", name = "comments")
@Entity(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(
        name = "doctor_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false)
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(
        name = "patient_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false)
    private PatientEntity patient;

    @Column(name = "date")
    private Instant date;

    @Column(name = "mark")
    private int mark;

    @Column(name = "comment")
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}