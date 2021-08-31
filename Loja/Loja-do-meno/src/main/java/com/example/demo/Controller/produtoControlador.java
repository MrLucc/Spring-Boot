package com.example.demo.Controller;


import com.example.demo.Repository.produtoRepositorio;
import com.example.demo.model.produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loja/produto")
public class produtoControlador {

    private @Autowired
    produtoRepositorio repositorio;


    @GetMapping("/all")
    public ResponseEntity<List<produto>> GetAll() {
        return ResponseEntity.ok(repositorio.findAll());
    }
    @PostMapping("/salvarProduto")
    public ResponseEntity<produto> salvarProduto (@Valid @RequestBody produto salvarProduto) {
        return ResponseEntity.status(201).body(repositorio.save(salvarProduto));
    }

    @GetMapping("/buscarPorId/{id_Produto}")
    public ResponseEntity<produto> buscarPorId(@PathVariable(value = "id_Produto")Long idProduto) {
        Optional<produto> objetoProduto = repositorio.findById(idProduto);

        if(objetoProduto.isPresent()) {
            return ResponseEntity.status(200).body(objetoProduto.get());
        }else{
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/buscarPorProduto/{nome_produto}")
    public ResponseEntity<List<produto>> buscarPorNomeProduto (@PathVariable(value = "nome_produto")String nome) {
        List<produto> objetoProduto = repositorio.findByNomeContainingIgnoreCase(nome);

        if(objetoProduto.isEmpty()){
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.status(200).body(objetoProduto);
        }
    }

    @DeleteMapping("/deletar/{id_produto}")
    public void deletarProdutoPorId(@PathVariable(value = "id_produto")Long idProduto){
        repositorio.deleteById(idProduto);
    }

    @PutMapping("/atualizarProduto")
    public ResponseEntity<produto> atualizarProduto(@Valid @RequestBody produto atualizarProduto) {
        return ResponseEntity.status(201).body(repositorio.save(atualizarProduto));
    }


}
