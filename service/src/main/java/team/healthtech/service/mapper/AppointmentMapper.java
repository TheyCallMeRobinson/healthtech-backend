package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import team.healthtech.db.entity.AppointmentEntity;
import team.healthtech.service.model.AppointmentDto;
import team.healthtech.service.model.create_dto.AppointmentCreateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "patientId", source = "patient.id")
    @Mapping(target = "doctorId", source = "timeRecord.doctor.id")
    @Mapping(target = "doctorFirstName", source = "timeRecord.doctor.firstName")
    @Mapping(target = "doctorMidName", source = "timeRecord.doctor.midName")
    @Mapping(target = "doctorLastName", source = "timeRecord.doctor.lastName")
    @Mapping(target = "patientFirstName", source = "patient.firstName")
    @Mapping(target = "patientMidName", source = "patient.midName")
    @Mapping(target = "patientLastName", source = "patient.lastName")
    AppointmentDto fromEntity(AppointmentEntity entity);

    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "timeRecord.doctor.id", source = "doctorId")
    AppointmentEntity toEntity(AppointmentDto dto);

    AppointmentEntity toEntity(AppointmentCreateDto dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient.id", source = "patientId")
    @Mapping(target = "timeRecord", ignore = true)
    AppointmentEntity toEntity(AppointmentCreateDto appointmentCreateDto, Integer patientId);

    void merge(AppointmentCreateDto appointmentCreateDto, @MappingTarget AppointmentEntity entity);

    List<AppointmentDto> fromEntities(Iterable<AppointmentEntity> entities);

}
