package io.github.leonardomvs.course.springmvc.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
