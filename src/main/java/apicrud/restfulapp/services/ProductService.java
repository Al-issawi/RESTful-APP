package apicrud.restfulapp.services;


import apicrud.restfulapp.entity.Products;
import org.apache.catalina.valves.LoadBalancerDrainingValve;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface ProductService {

    List<Products> findAll();

    Optional<Products> findById(Long id);

    Products save(Products products);

    Optional<Products> update(Long id, Products products);


    Optional<Products> delete(Long id);


}