package com.abctreinamentos.novasfuncionalidades.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abctreinamentos.novasfuncionalidades.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends MongoRepository<Funcionario, ObjectId>{

}
