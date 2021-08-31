package com.example.demo.Repository;

import com.example.demo.model.produto;
import org.springframework.data.jpa.repository.JpaRepository;
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

    public List<produto> findByNomeContainingIgnoreCase (String nome);
}
