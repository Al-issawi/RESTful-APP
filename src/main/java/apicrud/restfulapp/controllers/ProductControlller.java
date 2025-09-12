package apicrud.restfulapp.controllers;

import apicrud.restfulapp.entity.Products;
import apicrud.restfulapp.services.ProductService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductControlller {


        @Autowired
       private ProductService productService;

        /** get all products **/
        @GetMapping
        public List<Products> list(){
            return productService.findAll();
        }

        /** Git by ID Products **/
        //get products by ID.
        @GetMapping("/id")
       public ResponseEntity<?> view (@PathVariable Long id){
            Optional<Products> productsOptional = productService.findById(id);

            if(productsOptional.isPresent()){
                return ResponseEntity.ok(productsOptional.orElseThrow());
            }
            return ResponseEntity.notFound().build();
        }

        /** create Products **/

        @PostMapping
        public ResponseEntity<Products> create (@RequestBody Products product){

           return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
        }

        /** Update product **/
        @PutMapping("/id")
        public  ResponseEntity<Products> update(@PathVariable Long id,@RequestBody Products product){
            product.setId(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
        }


        /**Delete Product**/

        @DeleteMapping ("/id")
        public ResponseEntity<?> delete (@PathVariable Long id){

                Products product = new Products();
                product.setId(id);
            Optional<Products> productsOptional = productService.delete(product);

            if(productsOptional.isPresent()){
                return ResponseEntity.ok(productsOptional.orElseThrow());
            }
            return ResponseEntity.notFound().build();
        }
    }