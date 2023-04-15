package io.github.leonardomvs.course.springmvc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "funcionarios")
public class Funcionario extends AbstractEntity<Long> {

	private static final long serialVersionUID = 3380915874615832699L;
	
	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, unique = true)
	private String nome;
	
	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false)
	private BigDecimal salario;
	
	@NotNull
	@PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_entrada", nullable = false)
	private LocalDate dataEntrada;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_saida")
	private LocalDate dataSaida;
	
	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	@NotNull(message = "{NotNull.funcionario.cargo}")
	@ManyToOne
	@JoinColumn(name = "cargo_id_fk")
	private Cargo cargo;

}
