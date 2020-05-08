package br.com.aplicacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aplicacao.domain.orm.Individuo;

@Repository
public interface IndividuoRepository extends JpaRepository<Individuo, Long>{

}
