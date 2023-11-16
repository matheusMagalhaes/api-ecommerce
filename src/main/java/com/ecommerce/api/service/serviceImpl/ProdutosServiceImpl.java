package com.ecommerce.api.service.serviceImpl;

import com.ecommerce.api.model.DTO.ProdutoDTO;
import com.ecommerce.api.model.Produtos;
import com.ecommerce.api.repository.ProdutosRepository;
import com.ecommerce.api.service.ProdutosService;
import com.ecommerce.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProdutosServiceImpl implements ProdutosService {

    @Autowired
    ProdutosRepository repository;
    @Autowired
    ModelMapper mapper;

    @Override
    public List<Produtos> findAll() {
        return repository.findAll();
    }

    @Override
    public Produtos addProduto(ProdutoDTO produto) {
        Produtos prd = new Produtos();
        Utils util = new Utils();
        try {
            util.convertImgToByteArray(produto.getImg());
            this.mapper.map(produto, prd);

            return this.repository.save(prd);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
