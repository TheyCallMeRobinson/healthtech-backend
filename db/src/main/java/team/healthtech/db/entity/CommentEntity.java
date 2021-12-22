package team.healthtech.db.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.Instant;

@Table(schema = "ht_fix", name = "comments")
@Entity(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(
        name = "doctor_id",
        referencedColumnName = "id",
        updatable = false)
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(
        name = "patient_id",
        referencedColumnName = "id",
        updatable = false)
    private PatientEntity patient;

    @Column(name = "date")
    private Date date;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "comment")
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
