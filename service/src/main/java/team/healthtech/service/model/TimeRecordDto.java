package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

public class TimeRecordDto {

    private Integer id;

    @JsonProperty("doctor_id")
    private Integer doctorId;

    @JsonProperty("patient_id")
    private Integer patientId;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("start_time")
    private Time startTime;

    @JsonProperty("result")
    private String result;

    @JsonProperty("recipe")
    private String recipe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
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

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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
