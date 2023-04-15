package io.github.leonardomvs.course.springmvc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leonardomvs.course.springmvc.dao.FuncionarioDao;
import io.github.leonardomvs.course.springmvc.domain.Funcionario;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	FuncionarioDao dao;
	
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);		
	}

	@Override
	public void editar(Funcionario funcionario) {
		dao.save(funcionario);		
	}

	@Override
	public void excluir(Long id) {
		dao.deleteById(id);		
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorNome(String nome) {
		return dao.findByNomeContainingIgnoreCase(nome);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> buscarPorCargo(Long idCargo) {
		return dao.findByCargoIdEquals(idCargo);
	}

	@Override
	public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
		return dao.findByDataEntradaEqualsAndDataSaidaEquals(entrada, saida);
	}
	
}
