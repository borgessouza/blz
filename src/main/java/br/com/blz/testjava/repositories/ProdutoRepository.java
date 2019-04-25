package br.com.blz.testjava.repositories;

import br.com.blz.testjava.entity.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

    public Optional<Produto> findBySku(Long sku);

}
