package team.healthtech.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import team.healthtech.common.Role;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.db.repository.PatientRepository;
import team.healthtech.service.logic.PatientService;
import team.healthtech.service.mapper.PatientMapper;
import team.healthtech.service.model.PatientDto;
import team.healthtech.service.model.create_dto.PatientCreateDto;
import team.healthtech.service.security.HealthtechPasswordEncoder;
import team.healthtech.service.security.Profile;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.sql.Date;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PatientServiceImpl implements PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientServiceImpl.class);
    private final ObjectProvider<Profile> profileProvider;
    private final HealthtechPasswordEncoder passwordEncoder;
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Autowired
    public PatientServiceImpl(
        ObjectProvider<Profile> profileProvider,
        HealthtechPasswordEncoder passwordEncoder,
        PatientRepository patientRepository,
        //TimeRecordRepository
        PatientMapper patientMapper
    ) {
        this.profileProvider = profileProvider;
        this.passwordEncoder = passwordEncoder;
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientDto createPatient(@Valid PatientCreateDto patientDto) {
        if (profileProvider.getIfAvailable() == null) {
            logger.info("Create new Patient by anonymous");
        } else {
            logger.info("Create new Patient by {}", profileProvider.getIfAvailable());
        }

        String encodePassword = passwordEncoder.encode(patientDto.getPassword());
        patientDto.setPassword(encodePassword);
        patientDto.setRole(Role.PATIENT);
        PatientDto dto = Optional.of(patientDto)
            .map(patientMapper::toEntity)
            .map(patientRepository::save)
            .map(patientMapper::fromEntity)
            .orElseThrow();

        dto.setAge(getAgeOfPatient(patientMapper.toEntity(patientDto).getId()));

        return dto;
    }

    @Override
    @Transactional
    public void updatePatient(PatientCreateDto patientCreateDto, int patientId) {
        logger.info("Patient with id {} update request by {}", patientId, profileProvider.getIfAvailable());
        PatientEntity entity = patientRepository.findById(patientId).orElseThrow();

        if (patientCreateDto.getPassword() == null || patientCreateDto.getPassword().isBlank()) {
            patientCreateDto.setPassword(entity.getPassword());
        }
        if (!patientCreateDto.getPassword().isBlank()){
            logger.info("Patient with id {} password change", patientId);
            String encodedPassword = passwordEncoder.encode(patientCreateDto.getPassword());
            patientCreateDto.setPassword(encodedPassword);
        }
        if (patientCreateDto.getBirthdate() == null){
            patientCreateDto.setBirthdate(entity.getBirthdate());
        }

        patientCreateDto.setRole(Role.PATIENT);
        patientMapper.merge(patientCreateDto, entity);
        patientRepository.save(entity);
    }

    @Override
    public PatientDto getPatientById(int patientId) {
        logger.info("Patient with id {} get request by {}", patientId, profileProvider.getIfAvailable());
        PatientDto patientDto = patientMapper.fromEntity(patientRepository.findById(patientId).orElse(null));
        patientDto.setAge(getAgeOfPatient(patientId));
        return patientDto;
    }

    @Override
    @Transactional
    public void deletePatientById(int patientId) {
        logger.info("Patient with id {} delete request by {}", patientId, profileProvider.getIfAvailable());
        patientRepository.deleteById(patientId);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        logger.info("Patients list get request by {}", profileProvider.getIfAvailable());
        List<PatientDto> patients = patientMapper.fromEntities(patientRepository.findAll());
        for (var patient : patients) {
            patient.setAge(getAgeOfPatient(patient.getId()));
        }
        return patients;
    }

    private Integer getAgeOfPatient(Integer patientId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        return Period.between(
            patient.getBirthdate().toLocalDate(),
            new Date(System.currentTimeMillis()).toLocalDate()
        ).getYears();
    }
}
