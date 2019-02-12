package com.fornecedorcadastro.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FornecedorEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 2000, nullable = false)
    private String email;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String comment;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
