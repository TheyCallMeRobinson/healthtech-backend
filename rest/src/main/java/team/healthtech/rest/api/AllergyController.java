package team.healthtech.rest.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import team.healthtech.service.logic.AllergyService;
import team.healthtech.service.model.AllergyDto;

import java.util.List;

@RestController
@RequestMapping("/allergies")
public class AllergyController {

    private final AllergyService allergyService;

    @Autowired
    public AllergyController(AllergyService allergyService) {
        this.allergyService = allergyService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAllergy(
        @RequestBody AllergyDto allergyDto
    ) {
        allergyService.createAllergy(allergyDto);
    }

    @GetMapping
    public List<AllergyDto> getAllAllergies() {
        return allergyService.getAllAllergies();
    }
}
