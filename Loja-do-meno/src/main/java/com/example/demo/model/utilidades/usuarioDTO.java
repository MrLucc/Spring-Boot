package com.example.demo.model.utilidades;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class usuarioDTO {
    private @NotBlank @Email String email;
    private @NotBlank String senha;

    private Long id;
    private String nome;
    private String token;
}
