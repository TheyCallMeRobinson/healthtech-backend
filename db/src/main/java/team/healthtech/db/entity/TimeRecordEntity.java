package team.healthtech.db.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

@Table(schema = "healthtech", name = "time_records")
@Entity(name = "time_records")
public class TimeRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(
        name = "doctor_id",
        referencedColumnName = "id")
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(
        name = "patient_id",
        referencedColumnName = "id")
    private PatientEntity patient;

    @Column(name = "date")
    private Date date;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "result")
    private String result;

    @Column(name = "recipe")
    private String recipe;

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

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
