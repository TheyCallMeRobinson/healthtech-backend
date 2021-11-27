package team.healthtech.service.security;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import team.healthtech.db.entity.UserEntity;
import team.healthtech.service.security.ImmutableProfile.Builder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-27T15:41:00+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.jar, environment: Java 11.0.11 (Amazon.com Inc.)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public Profile toProfile(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        Builder profile = ImmutableProfile.builder();

        profile.id( userEntity.getId() );
        profile.login( userEntity.getLogin() );
        profile.email( userEntity.getEmail() );
        profile.role( userEntity.getRole() );

        return profile.build();
    }
}
