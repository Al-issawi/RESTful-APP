package apicrud.restfulapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
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
