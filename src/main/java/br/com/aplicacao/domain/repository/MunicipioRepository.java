package br.com.aplicacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aplicacao.domain.orm.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>{

	

}
