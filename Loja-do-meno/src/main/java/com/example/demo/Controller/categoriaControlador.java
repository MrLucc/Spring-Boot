package com.example.demo.Controller;


import com.example.demo.Repository.categoriaRepositorio;
import com.example.demo.model.categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inicio/loja/categoria")
public class categoriaControlador {

    private @Autowired
    categoriaRepositorio repositorio;

    @GetMapping("/all")
    public ResponseEntity<List<categoria>> GetAll() {
        return ResponseEntity.ok(repositorio.findAll());
    }

    @GetMapping("buscarPorId/{id_Categoria}")
    public ResponseEntity<categoria> BuscarPorId(@PathVariable(value = "id_Categoria") Long idCategoria) {
        Optional<categoria> objetoCategoria = repositorio.findById(idCategoria);

        if (objetoCategoria.isPresent()) {
            return ResponseEntity.status(200).body(objetoCategoria.get());
        } else {
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("buscarPorCategoria/{categoria}")
    public ResponseEntity<List<categoria>> BuscarPorCategoria (@PathVariable(value = "categoria") String categoria){
        List<categoria> objetoCategoria = repositorio.findByCategoriaContainingIgnoreCase(categoria);

        if(objetoCategoria.isEmpty()){
            return ResponseEntity.status(204).build();
        }else{
           return ResponseEntity.status(200).body(objetoCategoria);
        }
    }

    @PostMapping("/salvarCategoria")
    public ResponseEntity<categoria> salvarCategoria (@Valid @RequestBody categoria salvarCategoria) {
        return ResponseEntity.status(201).body(repositorio.save(salvarCategoria));
    }

    @DeleteMapping("/deletar/{id_categoria}")
    public void deletarCategoriaPorId(@PathVariable(value = "id_categoria")Long idCategoria) {
        repositorio.deleteById(idCategoria);
    }

    @PutMapping("/atualizarCategoria")
    public ResponseEntity<categoria> atualizarCategoria(@Valid @RequestBody categoria atualizarCategoria) {
        return ResponseEntity.status(201).body(repositorio.save(atualizarCategoria));
    }
}
