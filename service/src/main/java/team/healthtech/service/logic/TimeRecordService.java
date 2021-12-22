package team.healthtech.service.logic;

import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.service.model.TimeRecordDto;

import java.sql.Date;
import java.util.List;

public interface TimeRecordService {

    TimeRecordDto createTimeRecord(TimeRecordDto dto) throws Exception;

    void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId);

    void deleteTimeRecord(int timeRecordId);

    TimeRecordDto getTimeRecordByDoctorId(Date date, Integer doctorId);

    List<TimeRecordDto> getScheduleByDatesAndDoctorId(List<Date> dates, Integer doctorId);

    String getFreeTimeByDoctor(int doctorId);

    String getBusyTimeByDoctor(int doctorId);

    List<TimeRecordDto> getAllEndedTimeRecordsOfPatient(int patientId);

    List<TimeRecordDto> getAllPlannedTimeRecordsOfPatient(int patientId);
}
