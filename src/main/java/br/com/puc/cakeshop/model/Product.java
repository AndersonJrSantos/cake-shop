package br.com.puc.cakeshop.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;
    private String name;
    private String taste;
    private Double weight;
    private Integer stock;
    @OneToMany(mappedBy = "product")
    private Set<Request> demands;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Set<Request> getDemands() {
        return demands;
    }

    public void setDemands(Set<Request> demands) {
        this.demands = demands;
    }
}
