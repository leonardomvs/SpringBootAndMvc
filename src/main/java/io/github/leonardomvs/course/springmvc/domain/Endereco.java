package io.github.leonardomvs.course.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "enderecos")
public class Endereco extends AbstractEntity<Long> {

	private static final long serialVersionUID = -6887503468057225408L;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String logradouro;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String cidade;
	
	@NotNull(message = "{NotNull.endereco.uf}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@NotBlank
	@Size(min = 9, max = 9, message = "{Size.endereco.cep}")
	@Column(nullable = false, length = 9)
	private String cep;
	
	@NotNull(message = "{NotNull.endereco.numero}")
	@Digits(integer = 5, fraction = 0)
	@Column(nullable = false, length = 5)
	private Integer numero;
	
	@Size(max = 255)
	private String complemento;
	
}
