package team.healthtech.db.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(schema = "ht_fix", name = "administrators")
@Entity(name = "administrators")
public class AdminEntity extends UserEntity{
}
