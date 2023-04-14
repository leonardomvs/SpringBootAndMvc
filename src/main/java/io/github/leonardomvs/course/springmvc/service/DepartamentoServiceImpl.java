package io.github.leonardomvs.course.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leonardomvs.course.springmvc.dao.DepartamentoDao;
import io.github.leonardomvs.course.springmvc.domain.Departamento;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	DepartamentoDao dao;
	
	@Override
	public void salvar(Departamento departamento) {
		dao.save(departamento);		
	}

	@Override
	public void editar(Departamento departamento) {
		dao.save(departamento);		
	}

	@Override
	public void excluir(Long id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento buscarPorId(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		return !buscarPorId(id).getCargos().isEmpty();
	}
	
}
