package team.healthtech.db.entity;

import java.sql.Date;
import java.sql.Time;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TimeRecordEntity.class)
public abstract class TimeRecordEntity_ {

	public static volatile SingularAttribute<TimeRecordEntity, DoctorEntity> doctor;
	public static volatile SingularAttribute<TimeRecordEntity, Date> date;
	public static volatile SingularAttribute<TimeRecordEntity, Time> startTime;
	public static volatile SingularAttribute<TimeRecordEntity, Integer> id;
	public static volatile SingularAttribute<TimeRecordEntity, Time> endTime;

	public static final String DOCTOR = "doctor";
	public static final String DATE = "date";
	public static final String START_TIME = "startTime";
	public static final String ID = "id";
	public static final String END_TIME = "endTime";

}

