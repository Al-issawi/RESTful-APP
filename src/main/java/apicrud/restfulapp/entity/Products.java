package apicrud.restfulapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{NotEmpty.product.name}")
    @Size(min =3,max =20 )
    private String name;
    
    @NotNull (message = "{NotNull.product.price}")
    @Min(value = 500, message = "{Min.product.price}")
    private int price;


    @NotBlank(message = "{NotBlank.product.description}")
    private String descriptions;


    //getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescriptions() {
        return descriptions;
    }

    //****setters****//


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
