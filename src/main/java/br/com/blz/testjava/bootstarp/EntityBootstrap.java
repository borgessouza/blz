package br.com.blz.testjava.bootstarp;

import br.com.blz.testjava.DTO.TypeEnum;
import br.com.blz.testjava.entity.Invetory;
import br.com.blz.testjava.entity.Produto;
import br.com.blz.testjava.entity.Warehouses;
import br.com.blz.testjava.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class EntityBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }


    private void initData() {
        Produto produto1 = new Produto("Dove Men",
            new Invetory(Arrays.asList(
                new Warehouses("SP", 15, TypeEnum.PHYSICAL_STORE),
                new Warehouses("MG", 10, TypeEnum.PHYSICAL_STORE),
                new Warehouses("RJ", 15, TypeEnum.ECOMMERCE),
                new Warehouses("PA", 10, TypeEnum.ECOMMERCE)
            )),1L);
        produtoRepository.save(produto1);


    }

}
