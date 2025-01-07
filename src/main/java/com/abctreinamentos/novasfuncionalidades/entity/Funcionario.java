package com.abctreinamentos.novasfuncionalidades.entity;

import java.util.Objects;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="funcionarios")
public class Funcionario {
	
    private String nome;
    private int idade;
    private String cargo;
    private String departamento;
    private String cidade;
    private String estado;
    private String formatoTrabalho;
    private double salario;
    
	public Funcionario(String nome, int idade, String cargo, String departamento, String cidade, String estado,
			String formatoTrabalho, double salario) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.cargo = cargo;
		this.departamento = departamento;
		this.cidade = cidade;
		this.estado = estado;
		this.formatoTrabalho = formatoTrabalho;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFormatoTrabalho() {
		return formatoTrabalho;
	}
	public void setFormatoTrabalho(String formatoTrabalho) {
		this.formatoTrabalho = formatoTrabalho;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cargo, cidade, departamento, estado, formatoTrabalho, idade, nome, salario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(cargo, other.cargo) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(departamento, other.departamento) && Objects.equals(estado, other.estado)
				&& Objects.equals(formatoTrabalho, other.formatoTrabalho) && idade == other.idade
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}
	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", idade=" + idade + ", cargo=" + cargo + ", departamento=" + departamento
				+ ", cidade=" + cidade + ", estado=" + estado + ", formatoTrabalho=" + formatoTrabalho + ", salario="
				+ salario + "]";
	}
    
    

}
