package br.com.aplicacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aplicacao.config.ResourceNotFoundException;
import br.com.aplicacao.domain.orm.Telefone;
import br.com.aplicacao.domain.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private TelefoneRepository repo;

	public Telefone create(Telefone telefone) {
		return repo.save(telefone);
	}

	public List<Telefone> findAll() {
		return repo.findAll();
	}

	public Telefone findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));
	}

	public Telefone update(Telefone telefone) {
		Telefone p = repo.findById(telefone.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));

		p.setCodDiscagem(telefone.getCodDiscagem());
		p.setTelefone(telefone.getTelefone());
		return repo.save(p);
	}

	public void delete(Long id) {
		Telefone p = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));
		repo.delete(p);
	}

}
