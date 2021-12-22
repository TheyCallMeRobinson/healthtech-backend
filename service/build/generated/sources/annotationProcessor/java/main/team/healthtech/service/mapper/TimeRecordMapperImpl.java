package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.TimeRecordEntity;
import team.healthtech.service.model.TimeRecordDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-22T22:56:49+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class TimeRecordMapperImpl implements TimeRecordMapper {

    @Override
    public TimeRecordDto fromEntity(TimeRecordEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TimeRecordDto timeRecordDto = new TimeRecordDto();

        timeRecordDto.setId( entity.getId() );
        timeRecordDto.setDate( entity.getDate() );
        timeRecordDto.setStartTime( entity.getStartTime() );
        timeRecordDto.setResult( entity.getResult() );
        timeRecordDto.setRecipe( entity.getRecipe() );

        return timeRecordDto;
    }

    @Override
    public TimeRecordEntity toEntity(TimeRecordDto dto) {
        if ( dto == null ) {
            return null;
        }

        TimeRecordEntity timeRecordEntity = new TimeRecordEntity();

        timeRecordEntity.setId( dto.getId() );
        timeRecordEntity.setDate( dto.getDate() );
        timeRecordEntity.setStartTime( dto.getStartTime() );
        timeRecordEntity.setResult( dto.getResult() );
        timeRecordEntity.setRecipe( dto.getRecipe() );

        return timeRecordEntity;
    }

    @Override
    public List<TimeRecordDto> fromEntities(Iterable<TimeRecordEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<TimeRecordDto> list = new ArrayList<TimeRecordDto>();
        for ( TimeRecordEntity timeRecordEntity : entities ) {
            list.add( fromEntity( timeRecordEntity ) );
        }

        return list;
    }

    @Override
    public void merge(TimeRecordDto dto, TimeRecordEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setStartTime( dto.getStartTime() );
        entity.setResult( dto.getResult() );
        entity.setRecipe( dto.getRecipe() );
    }
}
