package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.UserEntity;
import team.healthtech.service.model.UserDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-22T21:19:30+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto fromEntity(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( entity.getId() );
        userDto.setLogin( entity.getLogin() );
        userDto.setEmail( entity.getEmail() );

        return userDto;
    }

    @Override
    public UserEntity toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( dto.getId() );
        userEntity.setLogin( dto.getLogin() );
        userEntity.setEmail( dto.getEmail() );

        return userEntity;
    }

    @Override
    public List<UserDto> fromEntities(Iterable<UserEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>();
        for ( UserEntity userEntity : entities ) {
            list.add( fromEntity( userEntity ) );
        }

        return list;
    }
}
