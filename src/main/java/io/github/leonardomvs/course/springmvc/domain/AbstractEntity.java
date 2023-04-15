package io.github.leonardomvs.course.springmvc.domain;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@EqualsAndHashCode
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {

	private static final long serialVersionUID = 5883797315072080692L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;
	
}
