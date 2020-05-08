package br.com.aplicacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aplicacao.domain.orm.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
