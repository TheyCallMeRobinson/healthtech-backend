package team.healthtech.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.CommentService;
import team.healthtech.service.model.create_dto.CommentCreateDto;
import team.healthtech.service.model.CommentDto;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @Secured("ROLE_PATIENT")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/doctor/{doctorId}")
    public CommentDto createComment(
        @RequestBody CommentCreateDto commentCreateDto,
        @PathVariable int doctorId
    ){
        return service.createComment(commentCreateDto, doctorId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/doctor/{doctorId}")
    public List<CommentDto> getAllCommentsOfDoctor(@PathVariable int doctorId){
        return service.getAllCommentsByDoctorId(doctorId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/patient/{patientId}/date/{date}")
    public List<CommentDto> getAllCommentsByDateAndPatientId(@PathVariable int patientId, @PathVariable Date date){
        return service.getAllCommentsByDateAndPatientId(patientId, date);
    }

}
