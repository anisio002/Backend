package br.com.aplicacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aplicacao.config.ResourceNotFoundException;
import br.com.aplicacao.domain.dto.IndividuoDTO;
import br.com.aplicacao.domain.orm.Endereco;
import br.com.aplicacao.domain.orm.Individuo;
import br.com.aplicacao.domain.orm.Municipio;
import br.com.aplicacao.domain.orm.Telefone;
import br.com.aplicacao.domain.repository.EnderecoRepository;
import br.com.aplicacao.domain.repository.IndividuoRepository;
import br.com.aplicacao.domain.repository.MunicipioRepository;

@Service
public class IndividuoService {

	@Autowired
	private IndividuoRepository repo;
	@Autowired
	private MunicipioRepository municipioREpo;
	@Autowired
	private EnderecoRepository enderecoRepo;

	public Individuo create(Individuo individuo) {
		return repo.save(individuo);
	}

	public List<Individuo> findAll() {
		return repo.findAll();
	}

	public Individuo findById(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));
	}

	public Individuo update(Individuo individuo) {
		Individuo p = repo.findById(individuo.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrado registro para esse ID"));

		p.setNome(individuo.getNome());
		p.setDataNasc(individuo.getDataNasc());
		p.setEmail(individuo.getEmail());

		return repo.save(p);
	}



	public Individuo fromDTO(IndividuoDTO objDto) {

		Municipio mu = municipioREpo.getOne(objDto.getMunicipioId());

		Endereco end = new Endereco(null, objDto.getRua(), objDto.getComplemento(), objDto.getBairro(), mu);
		
		end = enderecoRepo.save(end);
		
		Individuo ind = new Individuo(null, objDto.getNome(), objDto.getDataNasc(), objDto.getEmail(), end);

		Telefone t1 = new Telefone(null, objDto.getTelefone1(), objDto.getCodDiscagem1(), ind);
		ind.getTelefones().add(t1);

		if (objDto.getTelefone2() != null) {
			Telefone t2 = new Telefone(null,objDto.getCodDiscagem2(), objDto.getTelefone2(),  ind);
			ind.getTelefones().add(t2);
		}

		if (objDto.getTelefone3() != null) {
			Telefone t3 = new Telefone(null, objDto.getCodDiscagem3(), objDto.getTelefone3(), ind);
			ind.getTelefones().add(t3);
		}
		
		return ind;

	}

}
