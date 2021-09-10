package com.example.demo.Repository;


import com.example.demo.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface usuarioRepositorio extends JpaRepository<usuario, Long> {

    /**
     * Método utilizado para pesquisar coluna nome ContainigIgnoreCase
     *
     * @param nome do tipo String
     * @retrun List de Usuarios
     * @author MrLucc
     * @since 1.0
     */

     List<usuario> findAllByNomeContainingIgnoreCase(String nome);

    /**
     * Método utilizado para pesquisar coluna email
     *
     * @param email do tipo string
     * @retrun Optional com Usuario
     * @author MrLucc
     * @since 1.5
     */

    Optional<usuario> findByEmail(String email);
}
