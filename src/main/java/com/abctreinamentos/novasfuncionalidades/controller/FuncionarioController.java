package com.abctreinamentos.novasfuncionalidades.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
						<a href="/calcularFolhaFuncionarios">3. Calcular folha de Funcionários</a>
						<a href="/listarFuncioanariosIdadeMenor30">4. Funcionarios com idade menor de 30 anos</a>
						<a href="/listarFuncioanariosIdadeMaiorIgual30">5. Funcionarios com idade maior ou igual a  30 anos</a>
						<a href="/listarFuncionarioSalarioOrdenado">6. Listar  salario ordenado</a>
						<a href="/listarFuncionarioMenorSalario">7. Listar funcionario com menor salario</a>
						<a href="/listarFuncionarioMaisAntigo">8. Listar funcionario mais antigo</a>
						
						
						
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
	//Calcular folha dos funcionarios
	@GetMapping("/calcularFolhaFuncionarios")
	public  ResponseEntity<String> calcularFolhaFuncionarios()
	{
		List<Funcionario> funcionarios=funcionarioService.listAll();
		double somaSalarios=funcionarios.stream().mapToDouble(Funcionario::getSalario).sum();

		//java 13 -> Text Blocks
		String resposta="""
				{
				"Total da folha de pagamentos": %.2
				}
				""".formatted(somaSalarios);
				return new ResponseEntity<String>(resposta,HttpStatus.OK);
				
	}

	//Funcionarios com idade menor  que 30 anos
	@GetMapping("/listarFuncioanariosIdadeMenor30")
	public  ResponseEntity<String> listarFuncioanariosIdadeMenor30()
	{
		List<Funcionario> funcionarios=funcionarioService.listAll();
		long totalFuncionarios =funcionarios.stream().filter(f -> f.getIdade() < 30).count();
		double somaSalarios= funcionarios.stream()
		.filter(f -> f.getIdade() < 30).mapToDouble(Funcionario::getSalario).sum();
		double mediaSalarios= somaSalarios/totalFuncionarios;

		//java 13 -> Text Blocks
		String resposta="""
				{
				"Total de funcionários >= a  30 anos": %d, "Média salarial": %.2f
				}
				""".formatted(totalFuncionarios,mediaSalarios);
				return new ResponseEntity<String>(resposta,HttpStatus.OK);
				
	}

	//Funcionarios com idade maior ou igual  que 30 anos
	@GetMapping("/listarFuncioanariosIdadeMaiorIgual30")
	public  ResponseEntity<String> listarFuncioanariosIdadeMaiorIgual30()
	{
		List<Funcionario> funcionarios=funcionarioService.listAll();
		long totalFuncionarios =funcionarios.stream().filter(f -> f.getIdade() >= 30).count();
		double somaSalarios= funcionarios.stream()
		.filter(f -> f.getIdade() >= 30).mapToDouble(Funcionario::getSalario).sum();
		double mediaSalarios= somaSalarios/totalFuncionarios;

		//java 13 -> Text Blocks
		String resposta="""
				{
				"Total de funcionários >= a  30 anos": %d, "Média salarial": %.2f
				}
				""".formatted(totalFuncionarios,mediaSalarios);
				return new ResponseEntity<String>(resposta,HttpStatus.OK);
				
	}
	@GetMapping("/listarFuncionarioMaiorSalario")
	public ResponseEntity<Optional<Funcionario>> listarFuncionarioMaiorSalario()
	{
		List<Funcionario> funcionarios = funcionarioService.listAll();
		Optional<Funcionario> funcionario =funcionarios.stream()
		.reduce((f1,f2) ->f1.getSalario() >f2.getSalario() ? f1:f2);  //condição ternario
		return new ResponseEntity<Optional<Funcionario>>(funcionario,HttpStatus.OK);	
	} 
	@GetMapping("/listarFuncionarioMenorSalario")
	public ResponseEntity<Optional<Funcionario>> listarFuncionarioMenorSalario()
	{
		List<Funcionario> funcionarios = funcionarioService.listAll();
		Optional<Funcionario> funcionario =funcionarios.stream()
		.reduce((f1,f2) ->f1.getSalario() < f2.getSalario() ? f1:f2);  //condição ternario
		return new ResponseEntity<Optional<Funcionario>>(funcionario,HttpStatus.OK);	
	} 

	//Salario ordenado
	@GetMapping("/listarFuncionarioSalarioOrdenado")
	public ResponseEntity<List<Funcionario>> listarFuncionarioSalarioOrdenado()
	{
		List<Funcionario> funcionario =funcionarioService.listAll().stream()
		.sorted((f1,f2) -> Double.compare(f1.getSalario(), f2.getSalario())).toList();

		return new ResponseEntity<List<Funcionario>>(funcionario,HttpStatus.OK);	
	} 

	//Funcionario mais antigo
	@GetMapping("/listarFuncionarioMaisAntigo")
	public ResponseEntity<String> listarFuncionarioMaisAntigo()
	{
		List<Funcionario> funcionarios = funcionarioService.listAll();

		Optional<Funcionario> funcionario =funcionarios.stream()
		.reduce((f1,f2) ->f1.getIdade() < f2.getIdade() ? f1:f2);  //condição ternario
		
		int maiorIdade=0;
		String nome="";

		if(funcionario.isPresent())
		{
			maiorIdade=funcionario.get().getIdade();
			nome=funcionario.get().getNome();
		}

		LocalDate dataHoje=LocalDate.now();
		int anoNascimento= dataHoje.getYear() - maiorIdade;
		String resposta="""
			{
			"Nome do funcionario mais antigo": %s,
			"Ano de nascimento": %d
			}
			""".formatted(nome,anoNascimento);

			return new ResponseEntity<String>(resposta,HttpStatus.OK);
}
}

