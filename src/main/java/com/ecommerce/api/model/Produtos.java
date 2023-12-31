package com.ecommerce.api.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUTOS")
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NOME")
    @NotNull(message = "Name cannot be null")
    @NotBlank
    private String nome;

    @Column(name = "DESCRICAO")
    @NotNull(message = "Description cannot be null")
    @NotBlank
    private String descricao;

    @Lob
    @Column(name = "IMG")
    @NotNull(message = "Image cannot be null")
    @NotEmpty
    private byte[] img;

    @Column(name = "PRECO")
    @NotNull(message = "Price cannot be null")
    @NotBlank
    private BigDecimal preco;
}
