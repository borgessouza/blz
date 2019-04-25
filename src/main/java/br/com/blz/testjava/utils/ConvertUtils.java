package br.com.blz.testjava.utils;

import br.com.blz.testjava.DTO.InvetoryDTO;
import br.com.blz.testjava.DTO.ProdutoDTO;
import br.com.blz.testjava.DTO.WarehousesDTO;
import br.com.blz.testjava.entity.Invetory;
import br.com.blz.testjava.entity.Produto;
import br.com.blz.testjava.entity.Warehouses;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ConvertUtils {

    public ProdutoDTO convertToDTO(Produto produtoEntity) {
        return new ProdutoDTO(produtoEntity.getSku(),
            produtoEntity.getName(),
            new InvetoryDTO(produtoEntity.getInvetory().getQuantity(),
                produtoEntity.getInvetory().getWarehouses()
                    .stream()
                    .map(item -> new WarehousesDTO(item.getLocality(),
                        item.getQuantity(),item.getType()))
                    .collect(Collectors.toList())), produtoEntity.getMarketable());
    }


    public Produto convertTOEntity(ProdutoDTO produtoDTO) {
        return new Produto(produtoDTO.getSku(),
            produtoDTO.getName(),
            new Invetory(produtoDTO.getInvetoryDTO().getWarehousesDTOList()
                .stream()
                .map(item -> new Warehouses(item.getLocalist(),
                    item.getQuantity(),item.getType())).collect(Collectors.toList())));
    }

}
