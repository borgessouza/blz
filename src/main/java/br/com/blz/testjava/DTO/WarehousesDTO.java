package br.com.blz.testjava.DTO;

public class WarehousesDTO {

    private String localist;
    private Integer quantity;
    private TypeEnum type;

    public WarehousesDTO() {
    }

    public WarehousesDTO(String localist, Integer quantity, TypeEnum type) {
        this.localist = localist;
        this.quantity = quantity;
        this.type = type;
    }

    public String getLocalist() {
        return localist;
    }

    public void setLocalist(String localist) {
        this.localist = localist;
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
