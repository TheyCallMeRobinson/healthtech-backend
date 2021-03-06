package team.healthtech.service.validation;

import team.healthtech.service.validation.for_update.LoginUniqueForUpdate;
import team.healthtech.service.validation.validator.StringLoginUnique;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StringLoginUnique.class, LoginUniqueForUpdate.class})
public @interface LoginUnique {

    String message() default "login.already-exists";

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};

}
