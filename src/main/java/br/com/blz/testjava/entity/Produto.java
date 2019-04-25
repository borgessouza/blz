package br.com.blz.testjava.entity;


import javax.persistence.*;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long sku;
    private String name;
    @Embedded
    private Invetory invetory;
    private Boolean Marketable;


    public Produto() {
    }

    public Produto(String name, Invetory invetory, Long sku) {
        this.name = name;
        this.invetory = invetory;
        this.sku = sku;
    }

    public Produto(Long sku, String name, Invetory invetory) {
        this.sku = sku;
        this.name = name;
        this.invetory = invetory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Invetory getInvetory() {
        return invetory;
    }

    public void setInvetory(Invetory invetory) {
        this.invetory = invetory;
    }

    public Boolean getMarketable() {
        return Marketable;
    }

    public void setMarketable(Boolean marketable) {
        Marketable = marketable;
    }
}
