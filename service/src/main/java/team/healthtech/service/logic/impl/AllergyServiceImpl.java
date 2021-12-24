package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import team.healthtech.db.repository.AllergyRepository;
import team.healthtech.service.logic.AllergyService;
import team.healthtech.service.mapper.AllergyMapper;
import team.healthtech.service.model.AllergyDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllergyServiceImpl implements AllergyService {
    private static final Logger logger = LoggerFactory.getLogger(AllergyServiceImpl.class);
    private final AllergyRepository allergyRepository;
    private final AllergyMapper allergyMapper;

    public AllergyServiceImpl(
        AllergyRepository allergyRepository,
        AllergyMapper allergyMapper
    ) {
        this.allergyRepository = allergyRepository;
        this.allergyMapper = allergyMapper;
    }

    @Override
    public void createAllergy(AllergyDto allergyDto) {
        logger.info("New allergy create request");
        allergyRepository.save(allergyMapper.toEntity(allergyDto));
    }

    @Override
    public List<AllergyDto> getAllAllergies() {
        logger.info("All allergies get request");
        List<AllergyDto> allergies = new ArrayList<>();
        for (var allergy : allergyRepository.findAll()) {
            allergies.add(allergyMapper.fromEntity(allergy));
        }
        return allergies;
    }
}
