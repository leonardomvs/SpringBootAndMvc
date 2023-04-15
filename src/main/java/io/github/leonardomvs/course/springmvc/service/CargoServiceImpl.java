package io.github.leonardomvs.course.springmvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.leonardomvs.course.springmvc.dao.CargoDao;
import io.github.leonardomvs.course.springmvc.domain.Cargo;
import io.github.leonardomvs.course.springmvc.util.Constantes;
import io.github.leonardomvs.course.springmvc.util.PaginacaoUtil;

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
	@Transactional(readOnly = true)
	public PaginacaoUtil<Cargo> buscarPorPagina(int pagina, String direcao){
		Direction direction = Direction.fromString(direcao);		
		Pageable pageable = PageRequest.of(pagina - 1, Constantes.PAGE_SIZE, Sort.by(direction, "nome"));
		Page<Cargo> page = dao.findAll(pageable);
		return new PaginacaoUtil<>(page.getSize(), 
								   pagina, 
								   page.getTotalPages(), 
								   direcao,
								   page.getContent());		
	}

	@Override
	public boolean cargoTemFuncionarios(Long id) {
		return !buscarPorId(id).getFuncionarios().isEmpty();
	}
	
}