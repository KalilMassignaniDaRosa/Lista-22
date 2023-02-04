package br.edu.unoesc.backend_com_sb.api_rest_controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.backend_com_sb.model.Funcionario;

@RestController
@RequestMapping(value = "/api")
public class FuncionarioRestController {
	Funcionario f1 = new Funcionario("Fulano", 1 ,new BigDecimal("1500.00"));
	Funcionario f2 = new Funcionario("Goiabinha Boy", 2 ,new BigDecimal("2200.00"));
	
	List<Funcionario> Funcionarios;
	
	public FuncionarioRestController() {
		Funcionarios = new ArrayList<Funcionario>();
		
		Funcionarios.add(f1);
		Funcionarios.add(f2);
	}
	
	// Incluir Funcionario
	@PostMapping("/funcionarios")
	public Funcionario salvarFuncionario(@RequestBody Funcionario Funcionario) {
		System.out.println("Inserindo um novo Funcionario...");
		System.out.println(Funcionario);
		
		Funcionarios.add(Funcionario);
		
		System.out.println(this.listarFuncionarios());
		
		return Funcionario;
	}
	
	// Alterar Funcionario
	@PutMapping("/funcionarios")
	public Funcionario atualizarFuncionario(@RequestBody Funcionario Funcionario) {
		Funcionario f= acharPorNumeroDependente(Funcionario.getNumeroDependente());
		System.out.println(f);
		
		f.setNome(Funcionario.getNome());
		f.setSalario(Funcionario.getSalario());
		
		
		System.out.println("Atualizando o Funcionario...");
		System.out.println(f);
		
		System.out.println(this.listarFuncionarios());
		
		return f;
	}
	
	// Excluir Funcionario
	@DeleteMapping(value = "/funcionarios/{id}")
	public void deletarFuncionario(@PathVariable Integer id) {
		Funcionario f = acharPorNumeroDependente(id);
		System.out.println(f);
		
		Funcionarios.remove(f);
		
		System.out.println("Excluindo Funcionario [" + id + "]...");
		
		System.out.println(this.listarFuncionarios());
	}
	
	@GetMapping(value = "/funcionarios")
	public List<Funcionario> listarFuncionarios() {
		return Funcionarios;
	}
	
	@GetMapping(value = "/funcionarios/{id}")
	public Funcionario acharPorNumeroDependente(@PathVariable Integer id) {
		for (Funcionario Funcionario : Funcionarios) {
			if (Funcionario.getNumeroDependente().equals(id)) {
				return Funcionario;
			}
		}
		
		return null;
	}
}
