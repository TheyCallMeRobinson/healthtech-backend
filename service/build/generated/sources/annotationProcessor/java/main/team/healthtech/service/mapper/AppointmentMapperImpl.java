package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.db.entity.DoctorEntity;
import team.healthtech.db.entity.PatientEntity;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.create_dto.AppointmentCreateDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-20T15:29:02+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentDto fromEntity(AppointmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setPatientId( entityPatientId( entity ) );
        appointmentDto.setDoctorId( entityTimeRecordDoctorId( entity ) );
        appointmentDto.setId( entity.getId() );
        appointmentDto.setTaken( entity.isTaken() );
        appointmentDto.setDatetime( entity.getDatetime() );
        appointmentDto.setResult( entity.getResult() );
        appointmentDto.setRecipe( entity.getRecipe() );

        return appointmentDto;
    }

    @Override
    public AppointmentEntity toEntity(AppointmentDto dto) {
        if ( dto == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setPatient( appointmentDtoToPatientEntity( dto ) );
        appointmentEntity.setTimeRecord( appointmentDtoToTimeRecordEntity( dto ) );
        appointmentEntity.setId( dto.getId() );
        appointmentEntity.setTaken( dto.getTaken() );
        appointmentEntity.setDatetime( dto.getDatetime() );
        appointmentEntity.setResult( dto.getResult() );
        appointmentEntity.setRecipe( dto.getRecipe() );

        return appointmentEntity;
    }

    @Override
    public AppointmentEntity toEntity(AppointmentCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setTaken( dto.getTaken() );
        appointmentEntity.setDatetime( dto.getDatetime() );
        appointmentEntity.setResult( dto.getResult() );
        appointmentEntity.setRecipe( dto.getRecipe() );

        return appointmentEntity;
    }

    @Override
    public AppointmentEntity toEntity(AppointmentCreateDto appointmentCreateDto, Integer patientId) {
        if ( appointmentCreateDto == null && patientId == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        if ( appointmentCreateDto != null ) {
            appointmentEntity.setTaken( appointmentCreateDto.getTaken() );
            appointmentEntity.setDatetime( appointmentCreateDto.getDatetime() );
            appointmentEntity.setResult( appointmentCreateDto.getResult() );
            appointmentEntity.setRecipe( appointmentCreateDto.getRecipe() );
        }
        if ( patientId != null ) {
            appointmentEntity.setPatient( integerToPatientEntity( patientId ) );
        }

        return appointmentEntity;
    }

    @Override
    public void merge(AppointmentCreateDto appointmentCreateDto, AppointmentEntity entity) {
        if ( appointmentCreateDto == null ) {
            return;
        }

        entity.setTaken( appointmentCreateDto.getTaken() );
        entity.setDatetime( appointmentCreateDto.getDatetime() );
        entity.setResult( appointmentCreateDto.getResult() );
        entity.setRecipe( appointmentCreateDto.getRecipe() );
    }

    @Override
    public List<AppointmentDto> fromEntities(Iterable<AppointmentEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AppointmentDto> list = new ArrayList<AppointmentDto>();
        for ( AppointmentEntity appointmentEntity : entities ) {
            list.add( fromEntity( appointmentEntity ) );
        }

        return list;
    }

    private Integer entityPatientId(AppointmentEntity appointmentEntity) {
        if ( appointmentEntity == null ) {
            return null;
        }
        PatientEntity patient = appointmentEntity.getPatient();
        if ( patient == null ) {
            return null;
        }
        Integer id = patient.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer entityTimeRecordDoctorId(AppointmentEntity appointmentEntity) {
        if ( appointmentEntity == null ) {
            return null;
        }
        TimeRecordEntity timeRecord = appointmentEntity.getTimeRecord();
        if ( timeRecord == null ) {
            return null;
        }
        DoctorEntity doctor = timeRecord.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Integer id = doctor.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected PatientEntity appointmentDtoToPatientEntity(AppointmentDto appointmentDto) {
        if ( appointmentDto == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( appointmentDto.getPatientId() );

        return patientEntity;
    }

    protected DoctorEntity appointmentDtoToDoctorEntity(AppointmentDto appointmentDto) {
        if ( appointmentDto == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId( appointmentDto.getDoctorId() );

        return doctorEntity;
    }

    protected TimeRecordEntity appointmentDtoToTimeRecordEntity(AppointmentDto appointmentDto) {
        if ( appointmentDto == null ) {
            return null;
        }

        TimeRecordEntity timeRecordEntity = new TimeRecordEntity();

        timeRecordEntity.setDoctor( appointmentDtoToDoctorEntity( appointmentDto ) );

        return timeRecordEntity;
    }

    protected PatientEntity integerToPatientEntity(Integer integer) {
        if ( integer == null ) {
            return null;
        }

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setId( integer );

        return patientEntity;
    }
}
