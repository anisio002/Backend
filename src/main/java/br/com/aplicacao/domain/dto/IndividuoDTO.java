package br.com.aplicacao.domain.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class IndividuoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Date dataNasc;
	private String email;
	
	private String codDiscagem1;
	private String telefone1;
	private String codDiscagem2;
	private String telefone2;
	private String codDiscagem3;
	private String telefone3;
	
	private String rua;
	private String complemento;
	private String bairro;
	private Long municipioId;
	
	public IndividuoDTO() {
		
	}
	
	
	
	
}
