package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.PatientService;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.PatientDto;
import team.healthtech.service.model.create_dto.PatientCreateDto;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientDto createPatient(
        @RequestBody PatientCreateDto patientDto
    ) {
        return service.createPatient(patientDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PatientDto> getAllPatients() {
        return service.getAllPatients();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{patientId}")
    public void updatePatient(
        @RequestBody PatientCreateDto patientDto,
        @PathVariable int patientId
    ) {
        service.updatePatient(patientDto, patientId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{patientId}")
    public PatientDto getPatient(
        @PathVariable int patientId
    ) {
        return service.getPatientById(patientId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{patientId}/last_appointment")
    public Integer getLastAppointment(
        @PathVariable int patientId
    ) {
        return service.getLastAppointment(patientId);
    }

    @DeleteMapping("/{patientId}")
    public void deletePatient(
        @PathVariable int patientId
    ) {
        service.deletePatientById(patientId);
    }

}
