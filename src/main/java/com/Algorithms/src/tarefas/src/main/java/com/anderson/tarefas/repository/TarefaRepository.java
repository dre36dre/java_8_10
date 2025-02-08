package com.anderson.tarefas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.anderson.tarefas.entity.Tarefa;

//import com.anderson.tarefas.repository;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa,Long> {

}
