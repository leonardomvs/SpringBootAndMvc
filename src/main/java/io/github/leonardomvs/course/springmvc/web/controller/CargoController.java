package io.github.leonardomvs.course.springmvc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.leonardomvs.course.springmvc.domain.Cargo;
import io.github.leonardomvs.course.springmvc.domain.Departamento;
import io.github.leonardomvs.course.springmvc.service.CargoService;
import io.github.leonardomvs.course.springmvc.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	CargoService cargoService;
	
	@Autowired
	DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes attr) {
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "/cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cargo cargo, RedirectAttributes attr) {
		cargoService.editar(cargo);
		attr.addFlashAttribute("success", "Cargo editado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id, ModelMap model) {
		if(cargoService.cargoTemFuncionarios(id)) {
			model.addAttribute("fail", "Cargo não removido. Possui funcionário(s) vinculado(s).");
		} else {
			model.addAttribute("success", "Cargo excluído com sucesso.");
			cargoService.excluir(id);
		}
		return listar(model);
		
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos(){
		return departamentoService.buscarTodos();
	}
	
}