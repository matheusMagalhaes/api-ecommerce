package com.ecommerce.api.model.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String img;
    private BigDecimal preco;
}
