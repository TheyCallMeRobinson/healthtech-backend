package team.healthtech.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.db.repository.DiseaseRepository;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.logic.PatientDiseasesService;
import team.healthtech.service.mapper.DiseaseMapper;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.update_dto.DiseaseUpdateDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PatientDiseasesServiceImpl implements PatientDiseasesService {

    private final DiseaseMapper mapper;
    private final DiseaseRepository repository;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientDiseasesServiceImpl(
        DiseaseMapper mapper,
        DiseaseRepository repository, PatientRepository patientRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.patientRepository = patientRepository;
    }

    @Override
    public DiseaseDto createDisease(@Valid DiseaseCreateDto dto) {
        DiseaseEntity entity = mapper.toEntity(dto);
        //Optional<PatientEntity> patient = patientRepository.findById(1);//.orElseThrow();
        PatientEntity patient = patientRepository.findById(dto.getPatientId()).orElseThrow();
        entity.setPatient(patient);
        DiseaseEntity e = repository.save(entity);
        /*return Optional.of(entity)
            .map(repository::save)
            .map(mapper::fromEntity)
            .orElseThrow();*/
        return mapper.fromEntity(e);
    }

    @Override
    public void updateDisease(@Valid DiseaseUpdateDto diseaseDto, int diseaseId) {
        DiseaseEntity entity = repository.findById(diseaseId).orElseThrow();
        mapper.merge(diseaseDto, entity);
        repository.save(entity);
    }

    @Override
    public void deleteDisease(int diseaseId) {
        repository.deleteById(diseaseId);
    }

    @Override
    public DiseaseDto getDiseaseById(int diseaseId) {
        return repository.findById(diseaseId)
            .map(mapper::fromEntity)
            .orElse(null);
    }

    @Override
    public List<DiseaseDto> getAllDiseases(int patientId) {
        List<DiseaseEntity> list = repository.getAllDiseasesByPatientId(patientId);
        return mapper.fromEntities(list);
    }

}
