package com.MGS.models;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.SecondaryTable;

@Entity
@Table(name = "Colaboradores")
public class MGSModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private String cargo;
	private Integer idade;
	private String nascimento;
	private Integer telefone;
	private String endereco;
	private String alergia;
	private String probmedicos;
	private String medicacoes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public String getAlergia() {
		return alergia;
	}
	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}
	public String getProbmedicos() {
		return probmedicos;
	}
	public void setProbmedicos(String probmedicos) {
		this.probmedicos = probmedicos;
	}
	public String getMedicacoes() {
		return medicacoes;
	}
	public void setMedicacoes(String medicacoes) {
		this.medicacoes = medicacoes;
	}
	
}