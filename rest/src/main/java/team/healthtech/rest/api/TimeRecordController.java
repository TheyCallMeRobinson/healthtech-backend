package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.TimeRecordService;
import team.healthtech.service.model.DoctorDto;
import team.healthtech.service.model.TimeRecordDto;
import team.healthtech.service.model.create_dto.DoctorCreateDto;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("doctors/{doctorId}/timerecord")
public class TimeRecordController {
    private final TimeRecordService service;

    @Autowired
    public TimeRecordController(TimeRecordService service) {
        this.service = service;
    }

    @Secured("ROLE_DOCTOR")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public TimeRecordDto createTimeRecord(@RequestBody TimeRecordDto timeRecordDto) throws Exception {
        return service.createTimeRecord(timeRecordDto);
    }

    @GetMapping()
    public TimeRecordDto getLastTimeRecordByDoctorId(@RequestBody Date date, @PathVariable int doctorId) {
        return service.getTimeRecordByDoctorId(date, doctorId);
    }

    @GetMapping("/schedule")
    public List<TimeRecordDto> getScheduleByDatesAndDoctorId(@RequestBody List<Date> dates,
                                                             @PathVariable int doctorId) {
        return service.getScheduleByDatesAndDoctorId(dates, doctorId);
    }

    @Secured("ROLE_DOCTOR")
    @PutMapping("/{timeRecordId}")
    public void updateTimeRecord(@RequestBody TimeRecordDto timeRecordDto, @PathVariable int timeRecordId) {
        service.updateTimeRecord(timeRecordDto, timeRecordId);
    }

    @Secured("ROLE_DOCTOR")
    @DeleteMapping("/{timeRecordId}")
    public void deleteTimeRecordId(@PathVariable int timeRecordId) {
        service.deleteTimeRecord(timeRecordId);
    }

}
