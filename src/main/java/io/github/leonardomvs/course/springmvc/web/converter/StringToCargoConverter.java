package io.github.leonardomvs.course.springmvc.web.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import io.github.leonardomvs.course.springmvc.domain.Cargo;
import io.github.leonardomvs.course.springmvc.service.CargoService;

@Component
public class StringToCargoConverter implements Converter<String, Cargo> {

	@Autowired
	CargoService cargoService;
	
	@Override
	public Cargo convert(String text) {
		
		if(text == null || text.trim().isEmpty()) { return null; }
		
		Long id = Long.parseLong(text);
		
		return cargoService.buscarPorId(id);		
		
	}

}
