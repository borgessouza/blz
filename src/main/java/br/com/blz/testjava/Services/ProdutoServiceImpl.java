package br.com.blz.testjava.Services;

import br.com.blz.testjava.DTO.ProdutoDTO;
import br.com.blz.testjava.Exceptions.ProdutoDuplicadoException;
import br.com.blz.testjava.Exceptions.ProdutoNaoEncontradoException;
import br.com.blz.testjava.entity.Produto;
import br.com.blz.testjava.entity.Warehouses;
import br.com.blz.testjava.repositories.ProdutoRepository;
import br.com.blz.testjava.utils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ConvertUtils convertUtils;

    @Override
    public ProdutoDTO getProduto(Long sku) {
        Optional<Produto> resultado = produtoRepository.findBySku(sku);

        resultado.orElseThrow(() -> new ProdutoNaoEncontradoException("Produto não encontrado"));

        Integer quantity = resultado.get()
            .getInvetory()
            .getWarehouses()
            .stream()
            .map(Warehouses::getQuantity)
            .mapToInt(Integer::intValue)
            .sum();

        resultado.get().setMarketable(quantity > 0) ;
        resultado.get().getInvetory().setQuantity(quantity);

        return convertUtils.convertToDTO(resultado.get());
    }

    @Override
    public void atualizarProduto(ProdutoDTO produtoDTO) {
       Optional<Produto> resultado = produtoRepository.findBySku(produtoDTO.getSku());
       resultado.orElseThrow( () -> new ProdutoNaoEncontradoException("Produto não encontrado"));

       if ( resultado.isPresent() ) {
           Produto entityToSave = convertUtils.convertTOEntity(produtoDTO);
           entityToSave.setId(resultado.get().getId());
           produtoRepository.save(entityToSave);
       }
    }

    @Override
    public void apagarProduto(Long sku) {
        Optional<Produto> produtoApagar = produtoRepository.findBySku(sku);
        if (produtoApagar.isPresent()) {
            produtoRepository.delete(produtoApagar.get());
        }
    }

    @Override
    public Produto criarProduto(ProdutoDTO produto) {
       if ( produtoRepository.findBySku(produto.getSku()).isPresent() ) {
           throw new ProdutoDuplicadoException("Produto já existe");
       } else {
         return produtoRepository.save(
            convertUtils.convertTOEntity(produto)
        );
       }
   }
}
