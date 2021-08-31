package com.farmacia.farmacia.gen.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idCategoria;
    private @NotBlank String categoriaRemedio;
    private @NotBlank String formaRemedio;

    @OneToMany(mappedBy = "codigoProduto", cascade = CascadeType.REMOVE)
    private List<Produto> listaProduto;


    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoriaRemedio() {
        return categoriaRemedio;
    }

    public void setCategoriaRemedio(String categoriaRemedio) {
        this.categoriaRemedio = categoriaRemedio;
    }

    public String getFormaRemedio() {
        return formaRemedio;
    }

    public void setFormaRemedio(String formaRemedio) {
        this.formaRemedio = formaRemedio;
    }
}
