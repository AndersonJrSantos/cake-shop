package br.com.puc.cakeshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Demand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Product> products;

    @ElementCollection(targetClass=Integer.class)
    private List<Integer>qtd;

    public Demand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getQtd(int i) {
        return qtd.get(i);
    }

    public void setQtd(List<Integer> qtd) {
        this.qtd = qtd;
    }
}
