package com.ecommerce.api.controller;

import com.ecommerce.api.handlers.ResponseHandler;
import com.ecommerce.api.model.DTO.ProdutoDTO;
import com.ecommerce.api.model.Produtos;

import com.ecommerce.api.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/store-products/")
public class ProductController {

    @Autowired
    ProdutosService service;

    @RequestMapping("findAll")
    ResponseEntity<Object> findAll(){
        try {
            List<Produtos> produto  = this.service.findAll();
            return ResponseHandler.handlerResponse("All products", HttpStatus.OK, produto);
        }catch (Exception e){
            return ResponseHandler.handlerResponse("Error", HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @PostMapping("add-new-product")
    ResponseEntity<Object> addProduct(@RequestBody @Valid ProdutoDTO produto){
        try {
            Produtos addProduto = service.addProduto(produto);
            return ResponseHandler.handlerResponse("Succefully added", HttpStatus.OK, addProduto);
        }catch (Exception e){
            return   ResponseHandler.handlerResponse("Error" , HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("product-update")
    void updateAddedProduct(@RequestParam @Valid ProdutoDTO produto){
        this.service.updateAddedProduct(produto);
    }
}
