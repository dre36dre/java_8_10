package com.abctreinamentos.novasfuncionalidades.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abctreinamentos.novasfuncionalidades.entity.Funcionario;
import com.abctreinamentos.novasfuncionalidades.repository.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> listAll() {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarioRepository.findAll().forEach(funcionarios::add);
		return funcionarios;
	}

}
