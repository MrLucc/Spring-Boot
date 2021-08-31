package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class categoria {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCategoria;

    private  Boolean payToPlay;

    private  Boolean multiplayer;

    private @NotBlank String categoria;

    @OneToMany(mappedBy = "codigoProduto", cascade = CascadeType.REMOVE)
    private List<produto> listaDeProduto = new ArrayList<>();

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Boolean getPayToPlay() {
        return payToPlay;
    }

    public void setPayToPlay(Boolean payToPlay) {
        this.payToPlay = payToPlay;
    }

    public Boolean getMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(Boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
