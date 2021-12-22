package team.healthtech.db.entity;

import javax.persistence.*;
import java.util.List;

@Table(schema = "healthtech", name = "specialities")
@Entity(name = "specialities")
public class SpecialityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "speciality")
    private List<DoctorsSpecialitiesEntity> doctors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DoctorsSpecialitiesEntity> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorsSpecialitiesEntity> doctors) {
        this.doctors = doctors;
    }

}
