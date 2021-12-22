package team.healthtech.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.time.Instant;

public class CommentDto {

    @JsonProperty("doctor_id")
    private Integer doctorId;

    @JsonProperty("patient_id")
    private Integer patientId;

    private Integer mark;

    private String comment;

    @NotBlank(message = "date.is-null")
    @Future(message = "date.invalid")
    private Date date;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
