package br.edu.unoesc.backend_com_sb.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Funcionario {
	private String nome;
	private Integer numeroDependente;
	private BigDecimal	salario;
	private Date dataNascimento;
}
