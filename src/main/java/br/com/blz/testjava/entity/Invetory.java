package br.com.blz.testjava.entity;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.OneToMany;
import java.util.List;

public class Invetory {

    private Integer quantity;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<Warehouses> warehouses;

    public Invetory() {
    }

    public Invetory(List<Warehouses> warehouses) {
        this.warehouses = warehouses;
    }

    public Invetory(Integer quantity, List<Warehouses> warehouses) {
        this.quantity = quantity;
        this.warehouses = warehouses;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Warehouses> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouses> warehouses) {
        this.warehouses = warehouses;
    }
}
