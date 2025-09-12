package apicrud.restfulapp.services;

import apicrud.restfulapp.entities.Products;

import java.util.List;
import java.util.Optional;


public interface ProductService{

    List<Products> findAll();

    Optional<Products> findById(Long id);

    Products save(Products products);

     Optional<Products> delete (Products products);
}
