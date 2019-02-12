package com.fornecedorcadastro.controller;

import com.fornecedorcadastro.domain.FornecedorEntity;
import com.fornecedorcadastro.service.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("fornecedor")
public class FornecedorController {
	
    private	FornecedorService service;  
    
    @Autowired
    public FornecedorController(FornecedorService service)
    {
        this.service = service;
    }
		 
    @GetMapping("/todos")    
    public List<FornecedorEntity> findAll(){
        return service.findAll();
    }

    @PostMapping
    public FornecedorEntity addFornecedor(@RequestBody FornecedorEntity novoFornecedor){
    			
        return service.addFornecedor(novoFornecedor);
    }
    
    @PutMapping
    public FornecedorEntity updateFornecedor(@RequestBody FornecedorEntity updateFornecedor){
        return service.editaFornecedor(updateFornecedor);
    }

    @DeleteMapping("/{id}")
    public void deleteFornecedor(@PathVariable("id") int id){
        service.deleteFornecedor(id);
    }
}
