package com.anderson.tarefas.service;

import java.util.List;
import java.util.Optional;

//import com.anderson.entity;
import com.anderson.tarefas.entity.Tarefa;

public interface TarefaService {
	
	List<Tarefa> listAll();
	Optional<Tarefa> listByNumero(long numero);
	void save(Tarefa tarefa);
	void update(Tarefa tarefa);
	void delete(long tarefa);

}
