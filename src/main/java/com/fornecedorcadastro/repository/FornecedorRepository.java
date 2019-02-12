package com.fornecedorcadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fornecedorcadastro.domain.FornecedorEntity;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Integer> {

    FornecedorEntity findById(int id);
}
