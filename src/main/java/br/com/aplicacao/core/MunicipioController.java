package br.com.aplicacao.core;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.aplicacao.domain.orm.Municipio;
import br.com.aplicacao.services.MunicipioService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

	@Autowired
	private MunicipioService service;

	@ApiOperation(value = "Lista todos municípios presentes na tabela TAB_MUNICIPIO")
	@GetMapping
	public List<Municipio> findAll() {
		return service.findAll();
	}

	@ApiOperation(value = "Procura um Município por ID")
	@GetMapping("/{id}")
	public Municipio findById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@ApiOperation(value = "Exibi Municípios paginados por ID ")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Municipio>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Municipio> list = service.findPage(page, size, orderBy, direction);
		return ResponseEntity.ok().body(list);

	}

	@ApiOperation(value = "Inserção de um novo Município")
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Municipio municipio) {
		municipio = service.create(municipio);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(municipio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Atualiza por ID um município existente")
	@PutMapping
	public Municipio update(@RequestBody Municipio person) {
		return service.update(person);
	}

	@ApiOperation(value = "Remove por ID um município existente")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}
