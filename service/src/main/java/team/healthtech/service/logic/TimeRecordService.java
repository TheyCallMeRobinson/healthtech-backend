package team.healthtech.service.logic;

import team.healthtech.service.model.TimeRecordDto;

import java.sql.Date;
import java.util.List;

public interface TimeRecordService {

    TimeRecordDto createTimeRecord(TimeRecordDto dto) throws Exception;

    void updateTimeRecord(TimeRecordDto timeRecordDto, int timeRecordsId);

    void deleteTimeRecord(int timeRecordId);

    TimeRecordDto getTimeRecordByDoctorId(Date date, Integer doctorId);

    List<TimeRecordDto> getScheduleByDatesAndDoctorId(List<Date> dates, Integer doctorId);
}
