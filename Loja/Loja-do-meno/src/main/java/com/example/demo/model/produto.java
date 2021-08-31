package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_produto")
public class produto {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduto;

    private @NotBlank @Size(min = 3) String nome;

    private float preco;

    private String dataDeLancamento;

    @ManyToOne
    @JoinColumn(name = "listaDeProdutos")
    private categoria codigoProduto;


    public categoria getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(categoria codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDataDeLancamento() {
        return dataDeLancamento;
    }

}
