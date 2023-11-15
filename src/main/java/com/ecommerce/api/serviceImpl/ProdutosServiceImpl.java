package com.ecommerce.api.serviceImpl;

import com.ecommerce.api.model.Produtos;
import com.ecommerce.api.repository.ProdutosRepository;
import com.ecommerce.api.service.ProdutosService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServiceImpl implements ProdutosService {

    ProdutosRepository repository;
    @Override
    public List<Produtos> findAll() {
        return repository.findAll();
    }
}
