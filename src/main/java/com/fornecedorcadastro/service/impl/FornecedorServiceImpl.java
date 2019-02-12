package com.fornecedorcadastro.service.impl;

import com.fornecedorcadastro.service.FornecedorService;
import com.fornecedorcadastro.repository.FornecedorRepository;
import com.fornecedorcadastro.domain.FornecedorEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService
{
    @Autowired
    private FornecedorRepository repository;

    @Override
    final public List<FornecedorEntity> findAll()
    {
        return repository.findAll();
    }

    @Override
    final public FornecedorEntity addFornecedor(FornecedorEntity fornecedor)
    {
    	return repository.saveAndFlush(fornecedor);    	   	
    }

    @Override
    final public FornecedorEntity editaFornecedor(FornecedorEntity fornecedor)
    {
        return repository.saveAndFlush(fornecedor);
    }

    @Override
    final public void deleteFornecedor(int id)
    {
        repository.deleteById(id);
    }       
}
