package apicrud.restfulapp.repository;

import apicrud.restfulapp.entity.Products;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductsRepository extends CrudRepository <Products,Long> {


    boolean existsByTest(String test);
}

