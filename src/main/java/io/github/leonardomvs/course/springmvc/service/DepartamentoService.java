package io.github.leonardomvs.course.springmvc.service;

import java.util.List;

import io.github.leonardomvs.course.springmvc.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();

	boolean departamentoTemCargos(Long id);
	
}
