package br.com.aplicacao.core;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.aplicacao.domain.dto.IndividuoDTO;
import br.com.aplicacao.domain.orm.Individuo;
import br.com.aplicacao.domain.orm.Telefone;
import br.com.aplicacao.domain.repository.TelefoneRepository;
import br.com.aplicacao.services.IndividuoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/individuos")
public class IndividuoController {

	@Autowired
	private IndividuoService service;

	@Autowired
	private TelefoneRepository telefoneRepo;

	@ApiOperation(value = "Lista todos indivíduos presentes na tabela TAB_INDIVIDUO")
	@GetMapping
	public List<Individuo> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Procura um indivíduo por ID")
	@GetMapping("/{id}")
	public Individuo findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@ApiOperation(value = "Inserção de um novo Indivíduo")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody IndividuoDTO objDto) {
		Individuo obj = service.fromDTO(objDto);
		obj = service.create(obj);

		for (int i = 1; i < obj.getTelefones().size(); i++) {
			Telefone t = (Telefone) obj.getTelefones().get(i);
			t.setIndivid(obj);
			telefoneRepo.save(t);
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
