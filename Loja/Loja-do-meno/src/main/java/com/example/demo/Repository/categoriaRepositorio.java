package com.example.demo.Repository;

import com.example.demo.model.categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface categoriaRepositorio extends JpaRepository<categoria, Long> {
    /**
     * Método utilizado para buscar na coluna categoria
     * @param categoria
     * @author Lucas
     * @since 1.0
     *
     */
    public List<categoria> findByCategoriaContainingIgnoreCase (String categoria);


}
