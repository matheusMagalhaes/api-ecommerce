package com.ecommerce.api.controller;

import com.ecommerce.api.model.Produtos;

import com.ecommerce.api.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/store-products/")
public class ProductController {

    @Autowired
    ProdutosService service;

    @RequestMapping("find")
    List<Produtos> findAll(){
        return this.service.findAll();
    }
}
