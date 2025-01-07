package com.abctreinamentos.novasfuncionalidades.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.abctreinamentos.novasfuncionalidades.entity.Funcionario;

@Document
public interface FuncionarioRepository extends MongoRepository<Funcionario, ObjectId>{

}
