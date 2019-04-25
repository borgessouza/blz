package br.com.blz.testjava.controllers;

import br.com.blz.testjava.DTO.ProdutoDTO;
import br.com.blz.testjava.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping(value = "/add" , consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity inserirProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.criarProduto(produtoDTO);

        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.atualizarProduto(produtoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping(value = "/{sku}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ProdutoDTO> recuperarProduto(@PathVariable("sku") Long sku) {
        return new ResponseEntity<ProdutoDTO>(produtoService.getProduto(sku), HttpStatus.OK);
    }


    @DeleteMapping(value = "/{sku}")
    public ResponseEntity apagarProduto(@PathVariable("sku") Long sku) {
        produtoService.apagarProduto(sku);
        return new ResponseEntity(HttpStatus.OK);
    }








}
