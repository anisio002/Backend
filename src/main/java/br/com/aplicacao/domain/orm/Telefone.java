package br.com.aplicacao.domain.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TAB_INDIVIDUO_TELEFONE")
public class Telefone implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ddd",nullable = false)
	private String codDiscagem;
	
	@Column(name = "numero",nullable = false)
	private String telefone;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="individuo_id")
	private Individuo individ;
	

}
