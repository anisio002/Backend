package br.com.aplicacao.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.aplicacao.domain.orm.Telefone;
import br.com.aplicacao.services.TelefoneService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	@Autowired
	private TelefoneService service;

	@ApiOperation(value = "Lista todos números de telefones presentes na tabela TAB_INDIVIDUO_TELEFONE")
	@GetMapping
	public List<Telefone> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Procura um número de telefone por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Telefone obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Inserção de um novo número de telefone")
	@PostMapping
	public Telefone create(@RequestBody Telefone person) {
		return service.create(person);
	}

	@ApiOperation(value = "Atualiza por ID um número de telefone existente")
	@PutMapping
	public Telefone update(@RequestBody Telefone person) {
		return service.update(person);
	}

	@ApiOperation(value = "Remove por ID um número de telefone existente")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
