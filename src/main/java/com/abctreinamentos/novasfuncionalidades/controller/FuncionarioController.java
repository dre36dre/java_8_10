package com.abctreinamentos.novasfuncionalidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abctreinamentos.novasfuncionalidades.entity.Funcionario;
import com.abctreinamentos.novasfuncionalidades.service.FuncionarioService;

@RestController
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping("/")
	public ResponseEntity<String> inicio()
	{
		String response = """
				<html>
					<body>
						<a href="/listarFuncionarios">1. Listar Funcionários</a>
						<a href="/listarCidadesFuncionarios">2. Listar cidades Funcionários</a>
					</body>
				</html>
				""";
		
		return new ResponseEntity<String>(response,HttpStatus.OK);	
	}
	
	
	@GetMapping("/listarFuncionarios")
	public ResponseEntity<List<Funcionario>> listarFuncionarios()
	{
		List<Funcionario> funcionarios = funcionarioService.listAll();
		return new ResponseEntity<List<Funcionario>>(funcionarios,HttpStatus.OK);	
	}

	//Listar cidades
	@GetMapping("/listarCidadesFuncionarios")
	public ResponseEntity<List<String>> listarCidadesFuncionarios()
	{
		List<Funcionario> funcionarios = funcionarioService.listAll();
		List<String> cidades=funcionarios.stream().map(Funcionario::getCidade).toList();
		return new ResponseEntity<List<String>>(cidades,HttpStatus.OK);	
	} 
	//Lista soma de salarios


}
