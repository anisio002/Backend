package br.com.aplicacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aplicacao.domain.orm.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

}
