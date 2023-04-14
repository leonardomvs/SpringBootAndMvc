package io.github.leonardomvs.course.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leonardomvs.course.springmvc.dao.CargoDao;
import io.github.leonardomvs.course.springmvc.domain.Cargo;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	@Autowired
	CargoDao dao;
	
	@Override
	public void salvar(Cargo cargo) {
		dao.save(cargo);		
	}

	@Override
	public void editar(Cargo cargo) {
		dao.save(cargo);		
	}

	@Override
	public void excluir(Long id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo buscarPorId(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		return !buscarPorId(id).getFuncionarios().isEmpty();
	}
	
}