package team.healthtech.service.logic;

import team.healthtech.service.model.PatientDto;
import team.healthtech.service.model.create_dto.PatientCreateDto;

import javax.validation.Valid;
import java.util.List;

public interface PatientService {

    PatientDto createPatient(@Valid PatientCreateDto patientDto);

    void updatePatient(PatientCreateDto patientDto, int patientId);

    PatientDto getPatientById(int patientId);

    void deletePatientById(int patientId);

    List<PatientDto> getAllPatients();
}
