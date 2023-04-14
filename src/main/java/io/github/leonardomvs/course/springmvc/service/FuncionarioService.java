package io.github.leonardomvs.course.springmvc.service;

import java.util.List;

import io.github.leonardomvs.course.springmvc.domain.Funcionario;

public interface FuncionarioService {

	void salvar(Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();
	
}
