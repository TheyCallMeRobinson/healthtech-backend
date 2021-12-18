package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.DoctorSpecialityId;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;
import team.healthtech.service.model.DoctorDto;
import team.healthtech.service.model.SpecialityDto;
import team.healthtech.service.model.create_dto.DoctorCreateDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-27T16:39:51+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorDto fromEntity(DoctorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DoctorDto doctorDto = new DoctorDto();

        doctorDto.setId( entity.getId() );
        doctorDto.setLogin( entity.getLogin() );
        doctorDto.setEmail( entity.getEmail() );
        doctorDto.setFirstName( entity.getFirstName() );
        doctorDto.setMidName( entity.getMidName() );
        doctorDto.setLastName( entity.getLastName() );

        return doctorDto;
    }

    @Override
    public DoctorEntity toEntity(DoctorDto dto) {
        if ( dto == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId( dto.getId() );
        doctorEntity.setLogin( dto.getLogin() );
        doctorEntity.setEmail( dto.getEmail() );
        doctorEntity.setFirstName( dto.getFirstName() );
        doctorEntity.setMidName( dto.getMidName() );
        doctorEntity.setLastName( dto.getLastName() );

        return doctorEntity;
    }

    @Override
    public DoctorEntity toEntity(DoctorCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setLogin( dto.getLogin() );
        doctorEntity.setEmail( dto.getEmail() );
        doctorEntity.setPassword( dto.getPassword() );
        doctorEntity.setRole( dto.getRole() );
        doctorEntity.setFirstName( dto.getFirstName() );
        doctorEntity.setMidName( dto.getMidName() );
        doctorEntity.setLastName( dto.getLastName() );
        doctorEntity.setSpecialities( specialityDtoListToDoctorsSpecialitiesEntityList( dto.getSpecialities() ) );

        return doctorEntity;
    }

    @Override
    public DoctorSpecialityId map(Integer value) {
        if ( value == null ) {
            return null;
        }

        DoctorSpecialityId doctorSpecialityId = new DoctorSpecialityId();

        return doctorSpecialityId;
    }

    @Override
    public List<DoctorDto> fromEntities(Iterable<DoctorEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DoctorDto> list = new ArrayList<DoctorDto>();
        for ( DoctorEntity doctorEntity : entities ) {
            list.add( fromEntity( doctorEntity ) );
        }

        return list;
    }

    @Override
    public void merge(DoctorDto dto, DoctorEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setLogin( dto.getLogin() );
        entity.setEmail( dto.getEmail() );
        entity.setFirstName( dto.getFirstName() );
        entity.setMidName( dto.getMidName() );
        entity.setLastName( dto.getLastName() );
    }

    @Override
    public void merge(DoctorCreateDto dto, DoctorEntity entity) {
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
        if ( entity.getSpecialities() != null ) {
            List<DoctorsSpecialitiesEntity> list = specialityDtoListToDoctorsSpecialitiesEntityList( dto.getSpecialities() );
            if ( list != null ) {
                entity.getSpecialities().clear();
                entity.getSpecialities().addAll( list );
            }
            else {
                entity.setSpecialities( null );
            }
        }
        else {
            List<DoctorsSpecialitiesEntity> list = specialityDtoListToDoctorsSpecialitiesEntityList( dto.getSpecialities() );
            if ( list != null ) {
                entity.setSpecialities( list );
            }
        }
    }

    protected DoctorsSpecialitiesEntity specialityDtoToDoctorsSpecialitiesEntity(SpecialityDto specialityDto) {
        if ( specialityDto == null ) {
            return null;
        }

        DoctorsSpecialitiesEntity doctorsSpecialitiesEntity = new DoctorsSpecialitiesEntity();

        doctorsSpecialitiesEntity.setId( map( specialityDto.getId() ) );

        return doctorsSpecialitiesEntity;
    }

    protected List<DoctorsSpecialitiesEntity> specialityDtoListToDoctorsSpecialitiesEntityList(List<SpecialityDto> list) {
        if ( list == null ) {
            return null;
        }

        List<DoctorsSpecialitiesEntity> list1 = new ArrayList<DoctorsSpecialitiesEntity>( list.size() );
        for ( SpecialityDto specialityDto : list ) {
            list1.add( specialityDtoToDoctorsSpecialitiesEntity( specialityDto ) );
        }

        return list1;
    }
}
