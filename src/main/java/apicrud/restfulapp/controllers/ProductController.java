package apicrud.restfulapp.controllers;

import apicrud.restfulapp.entity.Products;
import apicrud.restfulapp.services.ProductService;
import jakarta.validation.Valid;
import org.apache.el.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {


        @Autowired
       private ProductService productService;

        /** get all products **/
        @GetMapping
        public List<Products> list(){

            return productService.findAll();
        }

        /** Git by ID Products **/
        //get products by ID.
        @GetMapping("/{id}")
       public ResponseEntity<?> view (@PathVariable Long id){
            Optional<Products> productsOptional = productService.findById(id);

            if(productsOptional.isPresent()){
                return ResponseEntity.ok(productsOptional.orElseThrow());
            }
            return ResponseEntity.notFound().build();
        }

        /** create Products **/

        @PostMapping
        public ResponseEntity<?> create (@Valid @RequestBody Products product, BindingResult bindingResult){

            if(bindingResult.hasFieldErrors()){

                return  Validation(bindingResult);
            }

           return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
        }

        /** Update product **/
        @PutMapping("/{id}")
        public  ResponseEntity<?> update(@Valid @RequestBody Products product,BindingResult bindingResult,@PathVariable Long id){

            if(bindingResult.hasFieldErrors()){

                return Validation(bindingResult);
            }
            Optional<Products> productsOptional = productService.update(id,product);


            if (productsOptional.isPresent()){

                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(productsOptional.orElseThrow());
            }

            return ResponseEntity.notFound().build();
        }


        /**Delete Product**/

        @DeleteMapping ("/{id}")
        public ResponseEntity<?> delete (@PathVariable Long id){

            Optional<Products> productsOptional = productService.delete(id);
            if(productsOptional.isPresent()){
                return ResponseEntity.ok(productsOptional.orElseThrow());
            }
            return ResponseEntity.notFound().build();
        }

        //validation
        private ResponseEntity<?> Validation (BindingResult bindingResult) {

            Map<String, String> errors = new HashMap();
            bindingResult.getFieldErrors().forEach(err ->{
                errors.put(err.getField()," "+err.getField()+ " "+ err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }
}