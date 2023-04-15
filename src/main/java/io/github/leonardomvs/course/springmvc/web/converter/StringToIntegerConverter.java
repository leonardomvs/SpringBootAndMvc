package io.github.leonardomvs.course.springmvc.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIntegerConverter implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		
		if(source == null) { return null; }
		
		source = source.trim();
		
		if(!source.matches("[0-9]+")) { return null; }
		
		return Integer.valueOf(source);
		
	}

}
