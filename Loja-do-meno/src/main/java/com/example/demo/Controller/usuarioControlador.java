package com.example.demo.Controller;


import com.example.demo.Repository.usuarioRepositorio;
import com.example.demo.model.usuario;
import com.example.demo.model.utilidades.usuarioDTO;
import com.example.demo.servicos.usuarioServicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class usuarioControlador {

    private @Autowired
    usuarioRepositorio repositorio;

    private @Autowired
    usuarioServicos servicos;

    @PostMapping("/salvar")
    public ResponseEntity<Object> salvar(@Valid @RequestBody usuario novoUsuario) {
        Optional<Object> objetoOptional = servicos.cadastrarUsuario(novoUsuario);

        if(objetoOptional.isEmpty()) {
            return ResponseEntity.status(400).build();
        }else{
            return ResponseEntity.status(201).body(objetoOptional.get());
        }
    }

    @PutMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody usuarioDTO usuarioParaAutenticar) {
        Optional<?> objetoOptional = servicos.fazerLogin(usuarioParaAutenticar);

        if(objetoOptional.isEmpty()) {
            return ResponseEntity.status(400).build();
        }else {
            return ResponseEntity.status(201).body(objetoOptional.get());
        }
    }

    @GetMapping("/todes")
    public ResponseEntity<List<usuario>> pegarTodes() {
        List<usuario> objetoLista = repositorio.findAll();

        if(objetoLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }else{
            return ResponseEntity.status(200).body(objetoLista);
        }
    }

    @GetMapping("/{id_usuario}")
    public ResponseEntity<usuario> buscarPorId(@PathVariable(value = "id_usuario") Long idUsuario) {
        Optional<usuario> objetoUsuario = repositorio.findById(idUsuario);

        if(objetoUsuario.isPresent()) {
            return ResponseEntity.status(200).body(objetoUsuario.get());
        }else {
            return ResponseEntity.status(204).build();
        }
    }

    @GetMapping("/nome/{nome_usuario}")
    public ResponseEntity<List<usuario>> buscarPorId1(@PathVariable(value = "nome_usuario")String nome) {
        List<usuario> objetoLista = repositorio.findAllByNomeContainingIgnoreCase(nome);

        if(objetoLista.isEmpty()) {
            return ResponseEntity.status(204).build();
        }else {
            return ResponseEntity.status(200).body(objetoLista);
        }
    }
}
