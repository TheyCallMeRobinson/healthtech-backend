package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.service.model.AllergyDto;
import team.healthtech.service.model.PatientDto;
import team.healthtech.service.model.create_dto.PatientCreateDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-22T21:19:30+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Override
    public PatientDto fromEntity(PatientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PatientDto patientDto = new PatientDto();

        patientDto.setId( entity.getId() );
        patientDto.setLogin( entity.getLogin() );
        patientDto.setEmail( entity.getEmail() );
        patientDto.setFirstName( entity.getFirstName() );
        patientDto.setMidName( entity.getMidName() );
        patientDto.setLastName( entity.getLastName() );
        patientDto.setSex( entity.getSex() );
        patientDto.setPhoneNumber( entity.getPhoneNumber() );
        patientDto.setAllergies( allergyEntityListToAllergyDtoList( entity.getAllergies() ) );

        return patientDto;
    }

    @Override
    public void merge(PatientDto dto, PatientEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setLogin( dto.getLogin() );
        entity.setEmail( dto.getEmail() );
        entity.setFirstName( dto.getFirstName() );
        entity.setMidName( dto.getMidName() );
        entity.setLastName( dto.getLastName() );
        entity.setSex( dto.getSex() );
        entity.setPhoneNumber( dto.getPhoneNumber() );
        if ( entity.getAllergies() != null ) {
            List<AllergyEntity> list = allergyDtoListToAllergyEntityList( dto.getAllergies() );
            if ( list != null ) {
                entity.getAllergies().clear();
                entity.getAllergies().addAll( list );
            }
            else {
                entity.setAllergies( null );
            }
        }
        else {
            List<AllergyEntity> list = allergyDtoListToAllergyEntityList( dto.getAllergies() );
            if ( list != null ) {
                entity.setAllergies( list );
            }
        }
    }

    @Override
    public void merge(PatientCreateDto dto, PatientEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setLogin( dto.getLogin() );
        entity.setEmail( dto.getEmail() );
        entity.setPassword( dto.getPassword() );
        entity.setRole( dto.getRole() );
        entity.setFirstName( dto.getFirstName() );
        entity.setMidName( dto.getMidName() );
        entity.setLastName( dto.getLastName() );
        entity.setBirthdate( dto.getBirthdate() );
        entity.setSex( dto.getSex() );
        entity.setPhoneNumber( dto.getPhoneNumber() );
    }

    @Override
    public void toEntity(PatientDto dto, PatientEntity original) {
        if ( dto == null ) {
            return;
        }

        original.setId( dto.getId() );
        original.setLogin( dto.getLogin() );
        original.setEmail( dto.getEmail() );
        original.setFirstName( dto.getFirstName() );
        original.setMidName( dto.getMidName() );
        original.setLastName( dto.getLastName() );
        original.setSex( dto.getSex() );
        original.setPhoneNumber( dto.getPhoneNumber() );
        if ( original.getAllergies() != null ) {
            List<AllergyEntity> list = allergyDtoListToAllergyEntityList( dto.getAllergies() );
            if ( list != null ) {
                original.getAllergies().clear();
                original.getAllergies().addAll( list );
            }
            else {
                original.setAllergies( null );
            }
        }
        else {
            List<AllergyEntity> list = allergyDtoListToAllergyEntityList( dto.getAllergies() );
            if ( list != null ) {
                original.setAllergies( list );
            }
        }
    }

    @Override
    public PatientEntity toEntity(PatientCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setLogin( dto.getLogin() );
        patientEntity.setEmail( dto.getEmail() );
        patientEntity.setPassword( dto.getPassword() );
        patientEntity.setRole( dto.getRole() );
        patientEntity.setFirstName( dto.getFirstName() );
        patientEntity.setMidName( dto.getMidName() );
        patientEntity.setLastName( dto.getLastName() );
        patientEntity.setBirthdate( dto.getBirthdate() );
        patientEntity.setSex( dto.getSex() );
        patientEntity.setPhoneNumber( dto.getPhoneNumber() );

        return patientEntity;
    }

    @Override
    public PatientEntity toEntity(PatientDto dto) {
        if ( dto == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( dto.getId() );
        patientEntity.setLogin( dto.getLogin() );
        patientEntity.setEmail( dto.getEmail() );
        patientEntity.setFirstName( dto.getFirstName() );
        patientEntity.setMidName( dto.getMidName() );
        patientEntity.setLastName( dto.getLastName() );
        patientEntity.setSex( dto.getSex() );
        patientEntity.setPhoneNumber( dto.getPhoneNumber() );
        patientEntity.setAllergies( allergyDtoListToAllergyEntityList( dto.getAllergies() ) );

        return patientEntity;
    }

    @Override
    public List<PatientDto> fromEntities(Iterable<PatientEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PatientDto> list = new ArrayList<PatientDto>();
        for ( PatientEntity patientEntity : entities ) {
            list.add( fromEntity( patientEntity ) );
        }

        return list;
    }

    protected AllergyDto allergyEntityToAllergyDto(AllergyEntity allergyEntity) {
        if ( allergyEntity == null ) {
            return null;
        }

        AllergyDto allergyDto = new AllergyDto();

        allergyDto.setId( allergyEntity.getId() );
        allergyDto.setName( allergyEntity.getName() );

        return allergyDto;
    }

    protected List<AllergyDto> allergyEntityListToAllergyDtoList(List<AllergyEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AllergyDto> list1 = new ArrayList<AllergyDto>( list.size() );
        for ( AllergyEntity allergyEntity : list ) {
            list1.add( allergyEntityToAllergyDto( allergyEntity ) );
        }

        return list1;
    }

    protected AllergyEntity allergyDtoToAllergyEntity(AllergyDto allergyDto) {
        if ( allergyDto == null ) {
            return null;
        }

        AllergyEntity allergyEntity = new AllergyEntity();

        if ( allergyDto.getId() != null ) {
            allergyEntity.setId( allergyDto.getId() );
        }
        allergyEntity.setName( allergyDto.getName() );

        return allergyEntity;
    }

    protected List<AllergyEntity> allergyDtoListToAllergyEntityList(List<AllergyDto> list) {
        if ( list == null ) {
            return null;
        }

        List<AllergyEntity> list1 = new ArrayList<AllergyEntity>( list.size() );
        for ( AllergyDto allergyDto : list ) {
            list1.add( allergyDtoToAllergyEntity( allergyDto ) );
        }

        return list1;
    }
}
