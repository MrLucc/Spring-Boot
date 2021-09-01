package com.farmacia.farmacia.gen.Controller;

import com.farmacia.farmacia.gen.model.Produto;
import com.farmacia.farmacia.gen.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farmacia/produto")
public class ProdutoController {
    private @Autowired
    ProdutoRepository repository;

    @GetMapping("/all")
    private ResponseEntity<List<Produto>> GetAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/buscarPorId/{id_produto}")
    private ResponseEntity<Produto> findId(@PathVariable(value = "id_produto")Long idProduto){
        Optional<Produto> objetoProduto = repository.findById(idProduto);

        if(objetoProduto.isPresent()){
            return ResponseEntity.status(200).body(objetoProduto.get());

        }else{
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/buscarPorNome/{nome_produto}")
    public ResponseEntity<List<Produto>> findByName(@PathVariable(value = "nome_produto")String nome){
        List<Produto> objetoProduto = repository.buscarNome(nome);

        if(objetoProduto.isEmpty()){
            return ResponseEntity.status(204).build();

        }else{
            return ResponseEntity.status(200).body(objetoProduto);
        }
    }

    @PostMapping("/salvarProduto")
    private ResponseEntity<Produto> saveProduto(@Valid @RequestBody Produto saveProduto){
        return ResponseEntity.status(201).body(repository.save(saveProduto));
    }

    @PutMapping("/atualizarProduto")
    private ResponseEntity<Produto> updateProduto(@Valid @RequestBody Produto updateProduto){
        return ResponseEntity.status(201).body(repository.save(updateProduto));
    }

    @DeleteMapping("/delete/{id_produto}")
    public void deleteCategoriaById(@PathVariable(value = "id_produto")Long idProduto){
        repository.deleteById(idProduto);
    }

}
