package io.github.leonardomvs.course.springmvc.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.leonardomvs.course.springmvc.domain.Funcionario;

@Repository
public interface FuncionarioDao extends JpaRepository<Funcionario, Long> {

	List<Funcionario> findByNomeContainingIgnoreCase(String nome);
	
	List<Funcionario> findByCargoIdEquals(Long idCargo);
	
	List<Funcionario> findByDataEntradaEqualsAndDataSaidaEquals(LocalDate dataEntrada, LocalDate dataSaida);
		
}
