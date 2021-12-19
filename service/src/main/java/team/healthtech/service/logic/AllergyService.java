package team.healthtech.service.logic;

import team.healthtech.service.model.AllergyDto;

import java.util.List;

public interface AllergyService {

    void createAllergy(AllergyDto allergyDto);

    List<AllergyDto> getAllAllergies();
}
