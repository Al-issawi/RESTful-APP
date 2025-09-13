package apicrud.restfulapp.services;


import apicrud.restfulapp.entity.Products;
import apicrud.restfulapp.repository.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImp implements ProductService {

    @Autowired
    private ProductsRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Products> findAll() {

        return (List<Products>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Products> findById(Long id) {

        return repository.findById(id);
    }

    @Transactional
    @Override
    public Products save(Products product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional <Products> delete(Products product) {
       Optional <Products> productOptional = repository.findById(product.getId());

        productOptional.ifPresent(prodDB ->
                {repository.delete(product);}
        );

        return productOptional;
    }
}
