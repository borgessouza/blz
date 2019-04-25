package br.com.blz.testjava.Services;

import br.com.blz.testjava.DTO.ProdutoDTO;
import br.com.blz.testjava.entity.Produto;

public interface ProdutoService {

    ProdutoDTO getProduto(Long sku);

    void atualizarProduto(ProdutoDTO produto);

    void apagarProduto(Long sku);

    Produto criarProduto(ProdutoDTO produto);


}
