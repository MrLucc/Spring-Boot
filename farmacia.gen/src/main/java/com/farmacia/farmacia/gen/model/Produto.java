package com.farmacia.farmacia.gen.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_produto")
public class Produto {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idProduto;
    private @NotBlank String laboratorio;
    private boolean tarjaPreta;
    private double preco;
    private @NotBlank String nome;

    @ManyToOne
    @JoinColumn(name = "listaProduto")
    private Categoria codigoProduto;

    public Categoria getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Categoria codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public boolean isTarjaPreta() {
        return tarjaPreta;
    }

    public void setTarjaPreta(boolean tarjaPreta) {
        this.tarjaPreta = tarjaPreta;
    }
}
