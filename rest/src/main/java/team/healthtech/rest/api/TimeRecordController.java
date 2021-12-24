package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.TimeRecordService;
import team.healthtech.service.model.TimeRecordDto;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/timerecord")
public class TimeRecordController {
    private final TimeRecordService service;

    @Autowired
    public TimeRecordController(TimeRecordService service) {
        this.service = service;
    }

    @Secured({"ROLE_DOCTOR", "ROLE_ADMIN"})
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TimeRecordDto createTimeRecord(@RequestBody TimeRecordDto timeRecordDto) throws Exception {
        return service.createTimeRecord(timeRecordDto);
    }

    @Secured({"ROLE_PATIENT", "ROLE_DOCTOR", "ROLE_ADMIN"})
    @GetMapping("/doctor/{doctorId}/date/{date}")
    public TimeRecordDto getLastTimeRecordByDoctorId(@PathVariable Date date, @PathVariable int doctorId) {
        return service.getTimeRecordByDoctorId(date, doctorId);
    }

    @Secured({"ROLE_PATIENT", "ROLE_DOCTOR", "ROLE_ADMIN"})
    @GetMapping("/schedule")
    public List<TimeRecordDto> getScheduleByDatesAndDoctorId(@RequestBody List<Date> dates,
                                                             @PathVariable int doctorId) {
        return service.getScheduleByDatesAndDoctorId(dates, doctorId);
    }

    @Secured({"ROLE_DOCTOR", "ROLE_ADMIN"})
    @PutMapping("/{timeRecordId}")
    public void updateTimeRecord(@RequestBody TimeRecordDto timeRecordDto, @PathVariable int timeRecordId) {
        service.updateTimeRecord(timeRecordDto, timeRecordId);
    }

    @DeleteMapping("/{timeRecordId}")
    public void deleteTimeRecordId(@PathVariable int timeRecordId) {
        service.deleteTimeRecord(timeRecordId);
    }

    @GetMapping("/doctor/{doctorId}/date/{date}/time/{time}")
    //@GetMapping("/doctor/{doctorId}?date={date}&time={time}")
    public TimeRecordDto getTimeRecordByDoctorIdAndDateAndTime(
        @PathVariable int doctorId, @PathVariable Date date, @PathVariable String time
    ) {
        return service.getTimeRecordByDoctorIdAndDateAndTime(doctorId, date, time);
    }

    @GetMapping("/doctor/{doctorId}/free")
    public String getDoctorFreeTimeByDoctor(@PathVariable int doctorId) {
        return service.getFreeTimeByDoctor(doctorId);
    }

    @GetMapping("/doctor/{doctorId}/busy")
    public String getDoctorBusyTimeByDoctor(@PathVariable int doctorId) {
        return service.getBusyTimeByDoctor(doctorId);
    }

    @GetMapping("/{patientId}/ended")
    public List<TimeRecordDto> getAllEndedTimeRecordsOfPatient(@PathVariable int patientId) {
        return service.getAllEndedTimeRecordsOfPatient(patientId);
    }

    @GetMapping("/{patientId}/planned")
    public List<TimeRecordDto> getAllPlannedTimeRecordsOfPatient(@PathVariable int patientId) {
        return service.getAllPlannedTimeRecordsOfPatient(patientId);
    }
}
