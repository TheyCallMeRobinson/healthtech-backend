package team.healthtech.db.entity;

import javax.persistence.*;
import java.util.List;

@Table(schema = "healthtech", name = "doctors")
@Entity(name = "doctors")
public class DoctorEntity extends UserEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "doctor")
    private List<DoctorsSpecialitiesEntity> specialities;

    @OneToMany(mappedBy = "doctor")
    private List<CommentEntity> comments;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Double getRating() {
//        return rating;
//    }
//
//    public void setRating(Double rating) {
//        this.rating = rating;
//    }

    public List<DoctorsSpecialitiesEntity> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<DoctorsSpecialitiesEntity> specialities) {
        this.specialities = specialities;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

}
