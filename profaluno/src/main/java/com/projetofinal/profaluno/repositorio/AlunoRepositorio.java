package com.projetofinal.profaluno.repositorio;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.projetofinal.profaluno.modelo.AlunoModelo;

public interface AlunoRepositorio extends Repository<AlunoModelo, Integer>{
	
	//Cadastrar
	void save(AlunoModelo aluno);
	
	//Selecionar todos os alunos
	List<AlunoModelo> findAll();
	
	//Selecionar aluno específico
	AlunoModelo findByCodigo(Integer codigo);	
	
	//Excluir
	void delete(AlunoModelo aluno);

}
