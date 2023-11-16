package com.ecommerce.api.controller;

import com.ecommerce.api.handlers.ResponseHandler;
import com.ecommerce.api.model.Produtos;

import com.ecommerce.api.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/store-products/")
public class ProductController {

    @Autowired
    ProdutosService service;

    @RequestMapping("findAll")
    List<Produtos> findAll(){
        return this.service.findAll();
    }

    @PostMapping("add-new-product")
    ResponseEntity<Object> addProduct(@RequestBody @Valid Produtos produto){
        try {
            Produtos addProduto = service.addProduto(produto);
            return ResponseHandler.handlerResponse("Succefully added", HttpStatus.OK, addProduto);
        }catch (Exception e){
            return   ResponseHandler.handlerResponse("Error" , HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
