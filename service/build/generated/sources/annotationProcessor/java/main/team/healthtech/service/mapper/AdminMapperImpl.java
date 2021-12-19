package team.healthtech.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.AdminEntity;
import team.healthtech.service.model.AdminDto;
import team.healthtech.service.model.create_dto.AdminCreateDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-19T22:23:00+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class AdminMapperImpl implements AdminMapper {

    @Override
    public AdminDto fromEntity(AdminEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AdminDto adminDto = new AdminDto();

        adminDto.setId( entity.getId() );
        adminDto.setLogin( entity.getLogin() );
        adminDto.setEmail( entity.getEmail() );

        return adminDto;
    }

    @Override
    public AdminEntity toEntity(AdminDto dto) {
        if ( dto == null ) {
            return null;
        }

        AdminEntity adminEntity = new AdminEntity();

        adminEntity.setId( dto.getId() );
        adminEntity.setLogin( dto.getLogin() );
        adminEntity.setEmail( dto.getEmail() );

        return adminEntity;
    }

    @Override
    public AdminEntity toEntity(AdminCreateDto dto) {
        if ( dto == null ) {
            return null;
        }

        AdminEntity adminEntity = new AdminEntity();

        adminEntity.setLogin( dto.getLogin() );
        adminEntity.setEmail( dto.getEmail() );
        adminEntity.setPassword( dto.getPassword() );
        adminEntity.setRole( dto.getRole() );

        return adminEntity;
    }

    @Override
    public List<AdminDto> fromEntities(Iterable<AdminEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AdminDto> list = new ArrayList<AdminDto>();
        for ( AdminEntity adminEntity : entities ) {
            list.add( fromEntity( adminEntity ) );
        }

        return list;
    }

    @Override
    public void merge(AdminDto dto, AdminEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setLogin( dto.getLogin() );
        entity.setEmail( dto.getEmail() );
    }

    @Override
    public void merge(AdminCreateDto dto, AdminEntity entity) {
        if ( dto == null ) {
            return;
        }

        entity.setLogin( dto.getLogin() );
        entity.setEmail( dto.getEmail() );
        entity.setPassword( dto.getPassword() );
        entity.setRole( dto.getRole() );
    }
}
