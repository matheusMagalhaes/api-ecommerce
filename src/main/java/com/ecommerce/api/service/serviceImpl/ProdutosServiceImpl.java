package com.ecommerce.api.service.serviceImpl;

import com.ecommerce.api.model.DTO.ProdutoDTO;
import com.ecommerce.api.model.Produtos;
import com.ecommerce.api.repository.ProdutosRepository;
import com.ecommerce.api.service.ProdutosService;
import com.ecommerce.api.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

        try {
            Utils.convertImgToByteArray(produto.getImg());
            this.mapper.map(produto, prd);

            return this.repository.save(prd);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAddedProduct(ProdutoDTO produto) {
        List<Produtos> listaProduto = this.repository.findAllById(Collections.singleton(produto.getId()));
         listaProduto.stream().filter(prd -> produto.getId() == prd.getId()).findFirst().ifPresent(prd ->{
             prd.setNome(produto.getNome());
             prd.setDescricao(produto.getDescricao());
             prd.setPreco(produto.getPreco());
             try {
               prd.setImg(Utils.convertImgToByteArray(produto.getImg()));
             }catch (Exception e){
                throw new RuntimeException("Failed to save image");
             }
         });
    }

}
