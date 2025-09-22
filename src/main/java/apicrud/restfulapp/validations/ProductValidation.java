package apicrud.restfulapp.validations;


import apicrud.restfulapp.entity.Products;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class ProductValidation  implements Validator {


    private String name;

    @Override
    public boolean supports(Class<?> clazz) {
        return Products.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Products product = (Products) target;

        //validation Product-name
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",  "NotEmpty.product.name");

        //validations Product-Description
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","NotBlank.product.description");
        if (product.getDescriptions()== null || product.getDescriptions().isBlank()){

            errors.rejectValue("description", "NotBlank.product.description");
        }

        //Product-Price
        if (product.getPrice()== null){
            errors.rejectValue("price","NotNull.product.price" );

        }else if (product.getPrice() < 500.0){
                errors.rejectValue("price", "Min.product.price");
            }
        }

    }


