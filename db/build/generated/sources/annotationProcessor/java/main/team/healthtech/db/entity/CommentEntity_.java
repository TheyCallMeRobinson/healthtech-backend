package team.healthtech.db.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CommentEntity.class)
public abstract class CommentEntity_ {

	public static volatile SingularAttribute<CommentEntity, DoctorEntity> doctor;
	public static volatile SingularAttribute<CommentEntity, Date> date;
	public static volatile SingularAttribute<CommentEntity, PatientEntity> patient;
	public static volatile SingularAttribute<CommentEntity, String> comment;
	public static volatile SingularAttribute<CommentEntity, Integer> id;
	public static volatile SingularAttribute<CommentEntity, Integer> mark;

	public static final String DOCTOR = "doctor";
	public static final String DATE = "date";
	public static final String PATIENT = "patient";
	public static final String COMMENT = "comment";
	public static final String ID = "id";
	public static final String MARK = "mark";

}

