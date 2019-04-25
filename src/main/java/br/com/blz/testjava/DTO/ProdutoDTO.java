package br.com.blz.testjava.DTO;

public class ProdutoDTO {

    private Long sku;
    private String name;
    private InvetoryDTO invetoryDTO;
    private Boolean isMarkeable;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long sku, String name, InvetoryDTO invetoryDTO) {
        this.sku = sku;
        this.name = name;
        this.invetoryDTO = invetoryDTO;
    }

    public ProdutoDTO(Long sku, String name, InvetoryDTO invetoryDTO, Boolean isMarkeable) {
        this.sku = sku;
        this.name = name;
        this.invetoryDTO = invetoryDTO;
        this.isMarkeable = isMarkeable;
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

    public InvetoryDTO getInvetoryDTO() {
        return invetoryDTO;
    }

    public void setInvetoryDTO(InvetoryDTO invetoryDTO) {
        this.invetoryDTO = invetoryDTO;
    }

    public Boolean getMarkeable() {
        return isMarkeable;
    }

    public void setMarkeable(Boolean markeable) {
        isMarkeable = markeable;
    }



}
