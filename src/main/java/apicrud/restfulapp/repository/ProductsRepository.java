package apicrud.restfulapp.repository;

import apicrud.restfulapp.entity.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductsRepository extends CrudRepository <Products,Long> {

}

