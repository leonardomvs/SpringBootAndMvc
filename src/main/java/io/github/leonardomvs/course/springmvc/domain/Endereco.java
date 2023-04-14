package io.github.leonardomvs.course.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "enderecos")
public class Endereco extends AbstractEntity<Long> {

	private static final long serialVersionUID = -6887503468057225408L;
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	@Column(nullable = false, length = 9)
	private String cep;
	
	@Column(nullable = false, length = 5)
	private Integer numero;
	
	@Column(nullable = true)
	private String complemento;
	
}
