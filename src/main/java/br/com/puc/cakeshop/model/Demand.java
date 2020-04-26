package br.com.puc.cakeshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Demand implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private Long id;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "demand")
    private Set<Request> products;

    private Integer qtd;

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

    public Set<Request> getProducts() {
        return products;
    }

    public void setProducts(Set<Request> products) {
        this.products = products;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}
