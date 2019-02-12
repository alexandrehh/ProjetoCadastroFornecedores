package com.fornecedorcadastro.service;

import com.fornecedorcadastro.domain.FornecedorEntity;

import java.util.List;

public interface FornecedorService {

    List<FornecedorEntity> findAll();

    FornecedorEntity addFornecedor(FornecedorEntity fornecedor);

    FornecedorEntity editaFornecedor(FornecedorEntity fornecedor);

    void deleteFornecedor(int id);   
}
