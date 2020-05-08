package br.com.aplicacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aplicacao.config.ResourceNotFoundException;
import br.com.aplicacao.domain.orm.Endereco;
import br.com.aplicacao.domain.repository.EnderecoRepository;
import io.swagger.annotations.ApiOperation;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;

	public Endereco create(Endereco endereco) {
		return repo.save(endereco);
	}

	public List<Endereco> findAll() {
		return repo.findAll();
	}

	public Endereco findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));
	}

	public Endereco update(Endereco endereco) {
		Endereco p = repo.findById(endereco.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));

		p.setRua(endereco.getRua());
		p.setComplemento(endereco.getComplemento());
		p.setBairro(endereco.getBairro());
		p.setMunicipio(endereco.getMunicipio());

		return repo.save(p);
	}

	public void delete(Long id) {
		Endereco p = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));
		repo.delete(p);
	}

}
