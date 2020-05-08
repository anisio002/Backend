package br.com.aplicacao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.aplicacao.config.ResourceNotFoundException;
import br.com.aplicacao.domain.orm.Municipio;
import br.com.aplicacao.domain.repository.MunicipioRepository;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository repo;

	public Municipio create(Municipio municipio) {
		return repo.save(municipio);
	}

	public List<Municipio> findAll() {
		return repo.findAll();
	}

	public Municipio findById(Long id) {
		Optional<Municipio> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));
	}

	public Municipio update(Municipio municipio) {
		Municipio p = repo.findById(municipio.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));

		p.setName(municipio.getName());
		p.setState(municipio.getState());
		return repo.save(p);
	}

	public void delete(Long id) {
		Municipio p = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));
		repo.delete(p);
	}

	public Page<Municipio> findPage(Integer page, Integer size, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
