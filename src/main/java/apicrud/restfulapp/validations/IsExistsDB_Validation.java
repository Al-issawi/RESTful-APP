package apicrud.restfulapp.validations;

import apicrud.restfulapp.services.ProductService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsExistsDB_Validation implements ConstraintValidator<IsExistsDB, String> {

    @Autowired
    private ProductService service;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

    return !service.existsByTest(value);

    }
}
