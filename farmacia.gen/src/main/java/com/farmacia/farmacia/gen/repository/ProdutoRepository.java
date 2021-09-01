

package com.farmacia.farmacia.gen.repository;

import com.farmacia.farmacia.gen.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /**
     * Método utilizado para buscar na coluna produto
     * @param nome
     * @author Lucas
     * @since 1.0
     */

    @Query("from Produto where nome like concat('%',?1'%')")
    public List<Produto>buscarNome(String nome);
    //public List<Produto> findByNomeContainingIgnoreCase (String nome);
}

