package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.DoctorService;
import team.healthtech.service.model.DoctorDto;
import team.healthtech.service.model.create_dto.DoctorCreateDto;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    @Autowired
    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public DoctorDto createDoctor(
        @RequestBody DoctorCreateDto doctorDto
    ) {
        return service.createDoctor(doctorDto);
    }

    @GetMapping
    public List<DoctorDto> getAllDoctors() {
        return service.getAllDoctors();
    }

    @Secured({"ROLE_ADMIN", "ROLE_DOCTOR"})
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{doctorId}")
    public void updateDoctor(
        @RequestBody DoctorCreateDto doctorDto,
        @PathVariable int doctorId
    ) {
        service.updateDoctor(doctorDto, doctorId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{doctorId}")
    public DoctorDto findDoctor(
        @PathVariable int doctorId
    ){
        return service.getDoctorById(doctorId);
    }

    @Secured("ROLE_ADMIN")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{doctorId}")
    public void deleteDoctor(
        @PathVariable int doctorId
    ){
        service.deleteDoctorById(doctorId);
    }

}
