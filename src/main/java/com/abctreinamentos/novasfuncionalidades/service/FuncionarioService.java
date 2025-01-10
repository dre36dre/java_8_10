package com.abctreinamentos.novasfuncionalidades.service;

import java.util.List;

import com.abctreinamentos.novasfuncionalidades.entity.Funcionario;

public interface FuncionarioService {

	List<Funcionario> listAll();
	
	default void printAll(){
		List<Funcionario> funcionarios= listAll();
		init();
		funcionarios.forEach(System.out::print);
	}

	static void calcularBonus(Funcionario funcionario)
	{
		List<Double> lista=List.of(0.1,0.15,0.2);

		double bonus = 0;

		if(funcionario.getSalario() <=5000  )
		bonus=funcionario.getSalario()*lista.get(2);
		else if(funcionario.getSalario()  <= 6000)
		bonus=funcionario.getSalario() *lista.get(1);
		else
		bonus=funcionario.getSalario()*lista.get(0);

		System.out.println(bonus);

	}

	private void init()
	{
		System.out.println("Listando todos os funcionarios da aplicação");
	}
}
