package team.healthtech.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import team.healthtech.db.entity.TimeRecordEntity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface TimeRecordsRepository extends CrudRepository<TimeRecordEntity, Integer>, JpaRepository<TimeRecordEntity, Integer>, JpaSpecificationExecutor<TimeRecordEntity> {

    @Query("select tr " +
        "from time_records tr " +
        "where doctor_id = ?1 and patient_id is null "
    )
    List<TimeRecordEntity> getFreeTimeRecordsOfDoctor(Integer doctorId);

    @Query("SELECT tr " +
        "FROM time_records tr " +
        "WHERE doctor_id = ?1 and patient_id is not null "
    )
    List<TimeRecordEntity> getBusyTimeRecordsOfDoctor(Integer doctorId);

    @Query("select tr " +
        "from time_records tr " +
        "where patient_id = ?1 and result is not null "
    )
    List<TimeRecordEntity> getEndedTimeRecordsByPatientId(Integer patientId);

    @Query("select tr " +
        "from time_records tr " +
        "where patient_id = ?1 and result is null "
    )
    List<TimeRecordEntity> getPlannedTimeRecordsByPatientId(Integer patientId);

    @Query("select tr\n" +
        "from time_records tr\n" +
        "where doctor_id = ?1 and date = ?2 and start_time = ?3 "
    )
    TimeRecordEntity getTimeRecordByDoctorIdAndDateAndTime(Integer doctorId, Date date, Time time);

    List<TimeRecordEntity> getTimeRecordEntitiesByDoctorId(Integer doctorId);

    TimeRecordEntity getTimeRecordEntityByDateAndDoctorId(Date date, Integer doctor_id);

}
