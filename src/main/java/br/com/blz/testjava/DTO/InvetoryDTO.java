package br.com.blz.testjava.DTO;


import java.util.List;

public class InvetoryDTO {

    private Integer quantity;
    private List<WarehousesDTO> warehousesDTOList;

    public InvetoryDTO() {
    }

    public InvetoryDTO(List<WarehousesDTO> warehousesDTOList) {
        this.warehousesDTOList = warehousesDTOList;
    }

    public InvetoryDTO(Integer quantity, List<WarehousesDTO> warehousesDTOList) {
        this.quantity = quantity;
        this.warehousesDTOList = warehousesDTOList;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<WarehousesDTO> getWarehousesDTOList() {
        return warehousesDTOList;
    }

    public void setWarehousesDTOList(List<WarehousesDTO> warehousesDTOList) {
        this.warehousesDTOList = warehousesDTOList;
    }
}
