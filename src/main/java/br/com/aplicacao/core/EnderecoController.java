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
import org.springframework.web.bind.annotation.RestController;

import br.com.aplicacao.domain.orm.Endereco;
import br.com.aplicacao.services.EnderecoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoService service;

	@ApiOperation(value = "Lista todos endereços presentes na tabela TAB_INDIVIDUO_ENDERECO")
	@GetMapping
	public List<Endereco> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Procura um endereço por ID")
	@GetMapping("/{id}")
	public Endereco findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@ApiOperation(value = "Inserção de um novo endereço")
	@PostMapping
	public Endereco create(@RequestBody Endereco endereco) {
		return service.create(endereco);
	}

	@ApiOperation(value = "Atualiza por ID um endereço existente")
	@PutMapping
	public Endereco update(@RequestBody Endereco endereco) {
		return service.update(endereco);
	}

	@ApiOperation(value = "Remove por ID um endereço existente")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
