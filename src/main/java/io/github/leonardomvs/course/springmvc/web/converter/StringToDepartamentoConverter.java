package io.github.leonardomvs.course.springmvc.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.github.leonardomvs.course.springmvc.domain.Departamento;
import io.github.leonardomvs.course.springmvc.service.DepartamentoService;

@Component
public class StringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	DepartamentoService departamentoService;
	
	@Override
	public Departamento convert(String text) {
		
		if(text == null || text.trim().isEmpty()) { return null; }
		
		Long id = Long.parseLong(text);
		
		return departamentoService.buscarPorId(id);		
		
	}

}
