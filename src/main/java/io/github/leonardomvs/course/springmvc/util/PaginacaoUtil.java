package io.github.leonardomvs.course.springmvc.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginacaoUtil<T> {

	private int tamanho;
	private int pagina;
	private long totalDePaginas;
	private String direcao;
	private List<T> registros;
	
}
