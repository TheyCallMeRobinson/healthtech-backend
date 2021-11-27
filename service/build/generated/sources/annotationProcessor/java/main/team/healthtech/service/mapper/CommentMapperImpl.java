package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.CommentEntity;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.service.model.CommentDto;
import team.healthtech.service.model.create_dto.CommentCreateDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-27T15:40:59+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDto fromEntity(CommentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CommentDto commentDto = new CommentDto();

        commentDto.setDoctorId( entityDoctorId( entity ) );
        commentDto.setPatientId( entityPatientId( entity ) );
        commentDto.setMark( entity.getMark() );
        commentDto.setComment( entity.getComment() );
        commentDto.setDate( entity.getDate() );

        return commentDto;
    }

    @Override
    public CommentEntity toEntity(CommentDto dto) {
        if ( dto == null ) {
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();

        commentEntity.setDoctor( commentDtoToDoctorEntity( dto ) );
        commentEntity.setPatient( commentDtoToPatientEntity( dto ) );
        commentEntity.setDate( dto.getDate() );
        commentEntity.setMark( dto.getMark() );
        commentEntity.setComment( dto.getComment() );

        return commentEntity;
    }

    @Override
    public CommentEntity toEntity(CommentCreateDto commentCreateDto, Integer doctorId) {
        if ( commentCreateDto == null && doctorId == null ) {
            return null;
        }

        CommentEntity commentEntity = new CommentEntity();

        if ( commentCreateDto != null ) {
            commentEntity.setPatient( commentCreateDtoToPatientEntity( commentCreateDto ) );
            commentEntity.setMark( commentCreateDto.getMark() );
            commentEntity.setComment( commentCreateDto.getComment() );
        }
        if ( doctorId != null ) {
            commentEntity.setDoctor( integerToDoctorEntity( doctorId ) );
        }

        return commentEntity;
    }

    @Override
    public List<CommentDto> fromEntities(Iterable<CommentEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CommentDto> list = new ArrayList<CommentDto>();
        for ( CommentEntity commentEntity : entities ) {
            list.add( fromEntity( commentEntity ) );
        }

        return list;
    }

    private Integer entityDoctorId(CommentEntity commentEntity) {
        if ( commentEntity == null ) {
            return null;
        }
        DoctorEntity doctor = commentEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Integer id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer entityPatientId(CommentEntity commentEntity) {
        if ( commentEntity == null ) {
            return null;
        }
        PatientEntity patient = commentEntity.getPatient();
        if ( patient == null ) {
            return null;
        }
        Integer id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected DoctorEntity commentDtoToDoctorEntity(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId( commentDto.getDoctorId() );

        return doctorEntity;
    }

    protected PatientEntity commentDtoToPatientEntity(CommentDto commentDto) {
        if ( commentDto == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( commentDto.getPatientId() );

        return patientEntity;
    }

    protected DoctorEntity integerToDoctorEntity(Integer integer) {
        if ( integer == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId( integer );

        return doctorEntity;
    }

    protected PatientEntity commentCreateDtoToPatientEntity(CommentCreateDto commentCreateDto) {
        if ( commentCreateDto == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( commentCreateDto.getPatientId() );

        return patientEntity;
    }
}
