package io.github.leonardomvs.course.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.leonardomvs.course.springmvc.domain.Funcionario;

@Repository
public interface FuncionarioDao extends JpaRepository<Funcionario, Long> {

}
