package team.healthtech.db.entity;

import team.healthtech.common.Role;

import javax.persistence.*;
/*
    MappedSuperClass InheritanceStrategy - две аннотации, которые позволяют организовывать наследование, где его по сути нет
    в реляционных бд их нет ни в каком виде, а с точки зрения кода - есть
 */
@Table(schema = "healthtech", name = "users")
@Entity(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Role role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
