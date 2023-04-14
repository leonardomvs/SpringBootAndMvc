package io.github.leonardomvs.course.springmvc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "funcionarios")
public class Funcionario extends AbstractEntity<Long> {

	private static final long serialVersionUID = 3380915874615832699L;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(nullable = false)
	private BigDecimal salario;
	
	@Column(name = "data_entrada", nullable = false)
	private LocalDate dataEntrada;
	
	@Column(name = "data_saida")
	private LocalDate dataSaida;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id_fk")
	private Cargo cargo;

}
