package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.DoctorSpecialityId;
import team.healthtech.db.entity.DoctorsSpecialitiesEntity;
import team.healthtech.service.model.DoctorSpecialitiesDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-19T22:23:00+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class DoctorSpecialitiesMapperImpl implements DoctorSpecialitiesMapper {

    @Override
    public DoctorSpecialitiesDto fromEntity(DoctorsSpecialitiesEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DoctorSpecialitiesDto doctorSpecialitiesDto = new DoctorSpecialitiesDto();

        doctorSpecialitiesDto.setSpecialityId( entityIdSpecialityId( entity ) );
        doctorSpecialitiesDto.setReceiveDate( entity.getReceiveDate() );

        return doctorSpecialitiesDto;
    }

    @Override
    public DoctorsSpecialitiesEntity toEntity(DoctorSpecialitiesDto dto, Integer doctorId) {
        if ( dto == null && doctorId == null ) {
            return null;
        }

        DoctorsSpecialitiesEntity doctorsSpecialitiesEntity = new DoctorsSpecialitiesEntity();

        if ( dto != null ) {
            if ( doctorsSpecialitiesEntity.getId() == null ) {
                doctorsSpecialitiesEntity.setId( new DoctorSpecialityId() );
            }
            doctorSpecialitiesDtoToDoctorSpecialityId( dto, doctorsSpecialitiesEntity.getId() );
            doctorsSpecialitiesEntity.setReceiveDate( dto.getReceiveDate() );
        }
        if ( doctorId != null ) {
            if ( doctorsSpecialitiesEntity.getId() == null ) {
                doctorsSpecialitiesEntity.setId( new DoctorSpecialityId() );
            }
            integerToDoctorSpecialityId( doctorId, doctorsSpecialitiesEntity.getId() );
        }

        return doctorsSpecialitiesEntity;
    }

    @Override
    public List<DoctorSpecialitiesDto> fromEntities(Iterable<DoctorsSpecialitiesEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<DoctorSpecialitiesDto> list = new ArrayList<DoctorSpecialitiesDto>();
        for ( DoctorsSpecialitiesEntity doctorsSpecialitiesEntity : entities ) {
            list.add( fromEntity( doctorsSpecialitiesEntity ) );
        }

        return list;
    }

    private Integer entityIdSpecialityId(DoctorsSpecialitiesEntity doctorsSpecialitiesEntity) {
        if ( doctorsSpecialitiesEntity == null ) {
            return null;
        }
        DoctorSpecialityId id = doctorsSpecialitiesEntity.getId();
        if ( id == null ) {
            return null;
        }
        Integer specialityId = id.getSpecialityId();
        if ( specialityId == null ) {
            return null;
        }
        return specialityId;
    }

    protected void integerToDoctorSpecialityId(Integer integer, DoctorSpecialityId mappingTarget) {
        if ( integer == null ) {
            return;
        }

        mappingTarget.setDoctorId( integer );
    }

    protected void doctorSpecialitiesDtoToDoctorSpecialityId(DoctorSpecialitiesDto doctorSpecialitiesDto, DoctorSpecialityId mappingTarget) {
        if ( doctorSpecialitiesDto == null ) {
            return;
        }

        mappingTarget.setSpecialityId( doctorSpecialitiesDto.getSpecialityId() );
    }
}
