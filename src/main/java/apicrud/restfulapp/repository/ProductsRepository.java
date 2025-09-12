package apicrud.restfulapp.repository;

import apicrud.restfulapp.entity.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository <Products,Long> {
}
