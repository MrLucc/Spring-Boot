package com.farmacia.farmacia.gen.Controller;

import com.farmacia.farmacia.gen.model.Categoria;
import com.farmacia.farmacia.gen.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farmacia/categoria")
public class CategoriaController {
    private @Autowired
    CategoriaRepository repository;

    @GetMapping("/all")
    private ResponseEntity<List<Categoria>> GetAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/buscarPorId/{id_categoria}")
    private ResponseEntity<Categoria> findId(@PathVariable(value = "id_categoria")Long idCategoria){
       Optional<Categoria> objetoCategoria = repository.findById(idCategoria);

       if(objetoCategoria.isPresent()){
           return ResponseEntity.status(200).body(objetoCategoria.get());

       }else{
           return ResponseEntity.status(204).build();
       }
    }

    @PostMapping("/salvarCategoria")
    private ResponseEntity<Categoria> saveCategoria(@Valid @RequestBody Categoria saveCategoria){
        return ResponseEntity.status(201).body(repository.save(saveCategoria));
    }

    @PutMapping("/atualizaCategoria")
    public ResponseEntity<Categoria> updateCategoria(@Valid @RequestBody Categoria updateCategoria){
        return ResponseEntity.status(201).body(repository.save(updateCategoria));
    }

    @DeleteMapping("/delete/{id_categoria}")
    public void deleteCategoriaById(@PathVariable(value = "id_categoria")Long idCategoria){
        repository.deleteById(idCategoria);
    }


}
