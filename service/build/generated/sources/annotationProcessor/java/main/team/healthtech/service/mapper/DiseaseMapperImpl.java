package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.DiseaseEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.service.model.DiseaseDto;
import team.healthtech.service.model.create_dto.DiseaseCreateDto;
import team.healthtech.service.model.update_dto.DiseaseUpdateDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-27T16:39:51+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class DiseaseMapperImpl implements DiseaseMapper {

    @Override
    public DiseaseDto fromEntity(DiseaseEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DiseaseDto diseaseDto = new DiseaseDto();

        diseaseDto.setPatientId( entityPatientId( entity ) );
        diseaseDto.setId( entity.getId() );
        diseaseDto.setName( entity.getName() );
        diseaseDto.setStartDate( entity.getStartDate() );
        diseaseDto.setEndDate( entity.getEndDate() );

        return diseaseDto;
    }

    @Override
    public DiseaseEntity toEntity(DiseaseCreateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        DiseaseEntity diseaseEntity = new DiseaseEntity();

        diseaseEntity.setPatient( diseaseCreateDtoToPatientEntity( createDto ) );
        diseaseEntity.setId( createDto.getId() );
        diseaseEntity.setName( createDto.getName() );
        diseaseEntity.setStartDate( createDto.getStartDate() );

        return diseaseEntity;
    }

    @Override
    public DiseaseEntity toEntity(DiseaseDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        DiseaseEntity diseaseEntity = new DiseaseEntity();

        diseaseEntity.setId( createDto.getId() );
        diseaseEntity.setName( createDto.getName() );
        diseaseEntity.setStartDate( createDto.getStartDate() );
        diseaseEntity.setEndDate( createDto.getEndDate() );

        return diseaseEntity;
    }

    @Override
    public DiseaseEntity toEntity(DiseaseUpdateDto createDto) {
        if ( createDto == null ) {
            return null;
        }

        DiseaseEntity diseaseEntity = new DiseaseEntity();

        diseaseEntity.setEndDate( createDto.getEndDate() );

        return diseaseEntity;
    }

    @Override
    public List<DiseaseDto> fromEntities(Iterable<DiseaseEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DiseaseDto> list = new ArrayList<DiseaseDto>();
        for ( DiseaseEntity diseaseEntity : entities ) {
            list.add( fromEntity( diseaseEntity ) );
        }

        return list;
    }

    @Override
    public void merge(DiseaseUpdateDto dto, DiseaseEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setEndDate( dto.getEndDate() );
    }

    private Integer entityPatientId(DiseaseEntity diseaseEntity) {
        if ( diseaseEntity == null ) {
            return null;
        }
        PatientEntity patient = diseaseEntity.getPatient();
        if ( patient == null ) {
            return null;
        }
        Integer id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected PatientEntity diseaseCreateDtoToPatientEntity(DiseaseCreateDto diseaseCreateDto) {
        if ( diseaseCreateDto == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( diseaseCreateDto.getPatientId() );

        return patientEntity;
    }
}
