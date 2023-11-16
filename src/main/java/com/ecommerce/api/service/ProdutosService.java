package com.ecommerce.api.service;

import com.ecommerce.api.model.Produtos;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ProdutosService {

    List<Produtos> findAll();


    Produtos addProduto(Produtos produto);
}
