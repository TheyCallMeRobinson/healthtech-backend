package team.healthtech.service.logic.impl;

import org.springframework.stereotype.Service;
import team.healthtech.db.repository.AllergyRepository;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.EntityNotFoundException;
import team.healthtech.service.logic.PatientAllergiesService;
import team.healthtech.service.mapper.PatientMapper;
import team.healthtech.service.model.AllergyDto;

import java.util.List;

@Service
public class PatientAllergiesServiceImpl implements PatientAllergiesService {

    private final AllergyRepository allergyRepository;
    private final PatientRepository patientRepository;

    public PatientAllergiesServiceImpl(
        AllergyRepository allergyRepository,
        PatientRepository patientRepository
    ) {
        this.allergyRepository = allergyRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void addAllergyToPatient(int allergyId, int patientId) {

    }

    @Override
    public void deleteAllergyFromPatient(int allergyId, int patientId) {
        // need to make a question
    }

    @Override
    public List<AllergyDto> getAllAllergiesFromPatient(int patientId) {
        return null;
    }

    @Override
    public AllergyDto getAllergyById(int allergyId) {
        /*
        return repository.findById(allergyId)
            .map(updateMapper::fromEntity)
            .orElse(null);

            need allergyMapper?

         */
        return null;
    }

}
