package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Future;
import java.time.Instant;

public class AppointmentDto {

    private Integer id;

    @JsonProperty("patient_id")
    private Integer patientId;

    @JsonProperty("doctor_id")
    private Integer doctorId;

    @JsonProperty("doctor_firstname")
    private String doctorFirstName;

    @JsonProperty("doctor_midname")
    private String doctorMidName;

    @JsonProperty("doctor_lastname")
    private String doctorLastName;

    @JsonProperty("patient_firstname")
    private String patientFirstName;

    @JsonProperty("patient_midname")
    private String patientMidName;

    @JsonProperty("patient_lastname")
    private String patientLastName;

    @JsonProperty("is_taken")
    private Boolean isTaken;

    private Instant datetime;

    private String result;

    private String recipe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    @JsonProperty("is_taken")
    public Boolean getTaken() {
        return isTaken;
    }

    @JsonProperty("is_taken")
    public void setTaken(Boolean taken) {
        isTaken = taken;
    }

    public Instant getDatetime() {
        return datetime;
    }

    public void setDatetime(Instant datetime) {
        this.datetime = datetime;
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

    public String getDoctorFirstName() {
        return doctorFirstName;
    }

    public void setDoctorFirstName(String doctorFirstName) {
        this.doctorFirstName = doctorFirstName;
    }

    public String getDoctorMidName() {
        return doctorMidName;
    }

    public void setDoctorMidName(String doctorMidName) {
        this.doctorMidName = doctorMidName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientMidName() {
        return patientMidName;
    }

    public void setPatientMidName(String patientMidName) {
        this.patientMidName = patientMidName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }
}
