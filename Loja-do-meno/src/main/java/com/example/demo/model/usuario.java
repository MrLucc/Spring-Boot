package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class usuario {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idUsuario;
    private @NotBlank String nome;
    private @NotBlank @Email String email;
    private @NotBlank @Size(min = 3) String senha;

    @OneToMany(mappedBy = "comprador", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties({"comprador"})
    private List<produto> listaDeCompradores = new ArrayList<>();

}
