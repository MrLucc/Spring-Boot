package com.example.demo.Repository;

import com.example.demo.model.produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface produtoRepositorio extends JpaRepository<produto, Long> {
    /**
     * Método utilizado para buscar na coluna nome
     * @param nome
     * @author Lucas
     * @since 1.0
     */

    @Query("from produto where nome like concat('%',?1,'%')")
    public List<produto> pesquisarProdutos(String nome);

    //public List<produto> findByNomeContainingIgnoreCase (String nome);
}
