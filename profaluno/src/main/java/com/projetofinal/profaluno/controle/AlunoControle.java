package com.projetofinal.profaluno.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.profaluno.modelo.AlunoModelo;
import com.projetofinal.profaluno.modelo.RespostaModelo;
import com.projetofinal.profaluno.repositorio.AlunoRepositorio;

@RestController
@CrossOrigin
@RequestMapping("/aluno")
public class AlunoControle {
	
	@Autowired
	private AlunoRepositorio acoes;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<AlunoModelo> listar(){
		return acoes.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody RespostaModelo cadastrar(@RequestBody AlunoModelo aluno) {
		try {
			acoes.save(aluno);
			return new RespostaModelo("Cadastro efetuado com sucesso!");
		}catch(Exception erro) {
			return new RespostaModelo("Falha ao cadastrar: "+erro.getMessage());
		}
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.GET)
	public @ResponseBody AlunoModelo buscar(@PathVariable("codigo") Integer cod) {
		return acoes.findByCodigo(cod);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody RespostaModelo alterar(@RequestBody AlunoModelo aluno) {
		try {
			acoes.save(aluno);
			return new RespostaModelo("Alteração efetuada com sucesso!");
		}catch(Exception erro) {
			return new RespostaModelo("Falha ao alterar: "+erro.getMessage());
		}
	}
	
	@RequestMapping(value="/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo excluir(@PathVariable("codigo") Integer cod) {
		try {
			AlunoModelo aluno = acoes.findByCodigo(cod);
			acoes.delete(aluno);
			return new RespostaModelo("Exclusão efetuada com sucesso!");
		}catch(Exception erro) {
			return new RespostaModelo("Falha ao excluir: "+erro.getMessage());
		}
	}

}
