package br.com.aplicacao.domain.repository;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.aplicacao.domain.orm.Endereco;
import br.com.aplicacao.domain.orm.Individuo;
import br.com.aplicacao.domain.orm.Municipio;

@SpringBootTest
public class IndividuoRepositoryTest {
	@Autowired
	private IndividuoRepository repo;

	@Test
	public void createShouldPersistData() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		Date date = sdf.parse("23/05/2001 15:20:00");

		Municipio mu = new Municipio(null, "Municipio", "MM");

		Endereco end = new Endereco(null, "Rua A", "", "Bairro", mu);

		Individuo individuo = new Individuo(null, "Anisio", date, "anisio@anisio.com", end);

		this.repo.save(individuo);
		Assertions.assertThat(individuo.getId()).isNotNull();
		Assertions.assertThat(individuo.getNome()).isEqualTo("Anisio");
		Assertions.assertThat(individuo.getEmail()).isEqualTo("anisio@anisio.com");
		Assertions.assertThat(individuo.getDataNasc()).isEqualTo(date);

	}

}
