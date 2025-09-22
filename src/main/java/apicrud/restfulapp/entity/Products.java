package apicrud.restfulapp.entity;

import apicrud.restfulapp.validations.IsExistsDB;
import apicrud.restfulapp.validations.IsRequired;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired(message = "{required.product.name}")
    @Size(min =3,max =20 )
    private String name;
    
    @NotNull (message = "{NotNull.product.price}")
    @Min(value = 500, message = "{Min.product.price}")
    private Double price;


    @IsRequired(message = "{required.product.description}")
    private String descriptions;

    @IsRequired
    @IsExistsDB
    private String test;



    //getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public String getTest() {
        return test;
    }

    //****setters****//


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
