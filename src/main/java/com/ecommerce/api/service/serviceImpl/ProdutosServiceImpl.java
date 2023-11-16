package com.ecommerce.api.service.serviceImpl;

import com.ecommerce.api.model.Produtos;
import com.ecommerce.api.repository.ProdutosRepository;
import com.ecommerce.api.service.ProdutosService;
import com.ecommerce.api.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServiceImpl implements ProdutosService {

    @Autowired
    ProdutosRepository repository;
    @Override
    public List<Produtos> findAll() {
        return repository.findAll();
    }

    @Override
    public Produtos addProduto(Produtos produto) {
        return repository.save(produto);
    }

}
