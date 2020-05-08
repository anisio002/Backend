package br.com.aplicacao.domain.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "TAB_INDIVIDUO")
public class Individuo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Temporal(javax.persistence.TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNasc;

	@Column(nullable = false)
	private String email;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@JsonManagedReference
	@OneToMany(mappedBy = "individ")
	private List<Telefone> telefones = new ArrayList<>();

	public Individuo(Long id,String nome, Date dataNasc, String email, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.email = email;
		this.endereco = endereco;
	}

	
}
