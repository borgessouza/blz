package br.com.blz.testjava.entity;

import br.com.blz.testjava.DTO.TypeEnum;

import javax.persistence.*;

@Entity
public class Warehouses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String locality;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private TypeEnum type;

    public Warehouses() {
    }

    public Warehouses(String locality, Integer quantity, TypeEnum type) {
        this.locality = locality;
        this.quantity = quantity;
        this.type = type;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }
}
