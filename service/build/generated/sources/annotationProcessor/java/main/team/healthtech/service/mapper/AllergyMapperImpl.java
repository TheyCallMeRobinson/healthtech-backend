package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.AllergyEntity;
import team.healthtech.service.model.AllergyDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-19T22:23:00+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class AllergyMapperImpl implements AllergyMapper {

    @Override
    public AllergyDto fromEntity(AllergyEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AllergyDto allergyDto = new AllergyDto();

        allergyDto.setId( entity.getId() );
        allergyDto.setName( entity.getName() );

        return allergyDto;
    }

    @Override
    public AllergyEntity toEntity(AllergyDto dto) {
        if ( dto == null ) {
            return null;
        }

        AllergyEntity allergyEntity = new AllergyEntity();

        if ( dto.getId() != null ) {
            allergyEntity.setId( dto.getId() );
        }
        allergyEntity.setName( dto.getName() );

        return allergyEntity;
    }

    @Override
    public List<AllergyDto> fromEntities(Iterable<AllergyEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AllergyDto> list = new ArrayList<AllergyDto>();
        for ( AllergyEntity allergyEntity : entities ) {
            list.add( fromEntity( allergyEntity ) );
        }

        return list;
    }
}
