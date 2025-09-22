package apicrud.restfulapp.services;


import apicrud.restfulapp.entity.Products;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Products> findAll();

    Optional<Products> findById(Long id);

    Products save(Products products);

    Optional<Products> update(Long id, Products products);


    Optional<Products> delete(Long id);


    boolean existsByTest(String test);
}