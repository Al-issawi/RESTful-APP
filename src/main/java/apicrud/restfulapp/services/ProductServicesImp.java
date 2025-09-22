package apicrud.restfulapp.services;

import apicrud.restfulapp.entity.Products;
import apicrud.restfulapp.repository.ProductsRepository;

import jakarta.validation.ConstraintValidatorContext;
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
    public Optional<Products> update(Long id, Products product) {

        Optional <Products> productOptional = repository.findById(id);

        if(productOptional.isPresent())
        {
            Products prodDB = productOptional.orElseThrow();
            prodDB.setName(product.getName());
            prodDB.setPrice(product.getPrice());
            prodDB.setDescriptions(product.getDescriptions());
            prodDB.setTest(product.getTest());

            return Optional.of(repository.save(prodDB));
        }

        return productOptional;
    }


    @Transactional
    @Override
    public Optional <Products> delete(Long id) {

       Optional <Products> productOptional = repository.findById(id);
            productOptional.ifPresent(prodDB ->
            {
            repository.delete(prodDB);
            });

        return productOptional;
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsByTest(String test) {

        return repository.existsByTest(test);
    }




}
