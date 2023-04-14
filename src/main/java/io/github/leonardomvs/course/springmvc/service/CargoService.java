package io.github.leonardomvs.course.springmvc.service;

import java.util.List;

import io.github.leonardomvs.course.springmvc.domain.Cargo;

public interface CargoService {

	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();
	
	boolean cargoTemFuncionarios(Long id);
	
}
