package com.ecommerce.api.service;

import com.ecommerce.api.model.DTO.ProdutoDTO;
import com.ecommerce.api.model.Produtos;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.util.List;

public interface ProdutosService {

    List<Produtos> findAll();


    Produtos addProduto(ProdutoDTO produto) throws IOException;
}
