package io.github.leonardomvs.course.springmvc.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.github.leonardomvs.course.springmvc.domain.Cargo;
import io.github.leonardomvs.course.springmvc.domain.Funcionario;
import io.github.leonardomvs.course.springmvc.domain.UF;
import io.github.leonardomvs.course.springmvc.service.CargoService;
import io.github.leonardomvs.course.springmvc.service.FuncionarioService;
import io.github.leonardomvs.course.springmvc.web.validator.FuncionarioValidator;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	CargoService cargoService;
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@InitBinder("funcionario")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new FuncionarioValidator());
	}
		
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return "funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {		
			return "funcionario/cadastro";
		}
		
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionario inserido com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable Long id, ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {		
			return "funcionario/cadastro";
		}
		
		funcionarioService.editar(funcionario);
		attr.addFlashAttribute("success", "Funcionario editado com sucesso.");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id, ModelMap model) {
		model.addAttribute("success", "Funcionario excluído com sucesso.");
		funcionarioService.excluir(id);
		return listar(model);
		
	}
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorNome(nome));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String getPorCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorCargo(id));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/data")
	public String getPorData(@RequestParam(name = "entrada", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate entrada,
							 @RequestParam(name = "saida", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate saida, 
							 ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarPorDatas(entrada, saida));
		return "funcionario/lista";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs(){
		return UF.values();
	}
	
}
