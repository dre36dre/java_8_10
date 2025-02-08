package com.anderson.tarefas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anderson.tarefas.entity.Tarefa;
import com.anderson.tarefas.repository.TarefaRepository;


@Service
public class TarefaImpl implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Override
	public List<Tarefa> listAll() 
	{
		List<Tarefa> tarefas = new ArrayList<>();
		tarefaRepository.findAll().forEach(tarefas::add);
		return tarefas;	
	}

	@Override
	public Optional<Tarefa> listByNumero(long numero) 
	{
		return tarefaRepository.findById(numero);		
	}

	@Override
	public void save(Tarefa tarefa) {
		tarefaRepository.save(tarefa);
	}

	@Override
	public void update(Tarefa tarefa) {
		
		Optional<Tarefa> tarefaEncontrada = 
				tarefaRepository.findById(tarefa.getNumero());	
		
		tarefaEncontrada.ifPresent(
			p -> {
				tarefaRepository.save(tarefa);
			}
		);		
	}

	@Override
	public void delete(long numero) {
		Optional<Tarefa> tarefaEncontrada = 
				tarefaRepository.findById(numero);	
		
		tarefaEncontrada.ifPresent(
			p -> {
				tarefaRepository.delete(tarefaEncontrada.get());
			}
		);	
		
	}

}
