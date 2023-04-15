package io.github.leonardomvs.course.springmvc.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "cargos")
public class Cargo extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1548573545955422357L;
	
	@NotBlank(message = "O nome do cargo é obrigatório.")
	@Size(max = 60, message = "O nome do cargo deve conter no máximo {max} caracteres.")
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@NotNull(message = "Selecione o departamento relativo ao cargo.")
	@ManyToOne
	@JoinColumn(name = "id_departamento_fk")
	private Departamento departamento;

	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;
	
}
