package br.com.aplicacao.domain.orm;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TAB_INDIVIDUO_ENDERECO")
public class Endereco  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="logradouro",nullable = false)
	private String rua;
	
	private String complemento;
	
	@Column(nullable = false)
	private String bairro;
	

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.PERSIST )
	@JoinColumn(name="municipio_id")
	private Municipio municipio;

}
