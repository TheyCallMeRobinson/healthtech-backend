package team.healthtech.db.entity;

import javax.persistence.*;
import java.sql.Date;

@Table(schema = "healthtech", name = "doctors_specialities")
@Entity(name = "doctors_specialities")
public class DoctorsSpecialitiesEntity {

    @EmbeddedId
    private DoctorSpecialityId id;

    @Column(name = "receive_date")
    private Date receiveDate;

    @ManyToOne
    @JoinColumn(
        name = "doctor_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private DoctorEntity doctor;

    @ManyToOne
    @JoinColumn(
        name = "speciality_id",
        referencedColumnName = "id",
        insertable = false,
        updatable = false
    )
    private SpecialityEntity specialityEntity;

    public DoctorSpecialityId getId() {
        return id;
    }

    public void setId(DoctorSpecialityId id) {
        this.id = id;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

}
