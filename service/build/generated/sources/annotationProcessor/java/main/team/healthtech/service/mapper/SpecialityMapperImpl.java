package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.SpecialityEntity;
import team.healthtech.service.model.SpecialityDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-24T12:59:58+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class SpecialityMapperImpl implements SpecialityMapper {

    @Override
    public SpecialityDto fromEntity(SpecialityEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SpecialityDto specialityDto = new SpecialityDto();

        specialityDto.setId( entity.getId() );
        specialityDto.setName( entity.getName() );

        return specialityDto;
    }

    @Override
    public SpecialityEntity toEntity(SpecialityDto dto) {
        if ( dto == null ) {
            return null;
        }

        SpecialityEntity specialityEntity = new SpecialityEntity();

        if ( dto.getId() != null ) {
            specialityEntity.setId( dto.getId() );
        }
        specialityEntity.setName( dto.getName() );

        return specialityEntity;
    }

    @Override
    public List<SpecialityDto> fromEntities(Iterable<SpecialityEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<SpecialityDto> list = new ArrayList<SpecialityDto>();
        for ( SpecialityEntity specialityEntity : entities ) {
            list.add( fromEntity( specialityEntity ) );
        }

        return list;
    }
}
