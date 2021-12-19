package team.healthtech.service.mapper;

import org.mapstruct.Mapper;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.service.model.AllergyDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AllergyMapper {

    AllergyDto fromEntity(AllergyEntity entity);

    AllergyEntity toEntity(AllergyDto dto);

    List<AllergyDto> fromEntities(Iterable<AllergyEntity> entities);

}
