package br.com.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Pessoa;

@Repository
@EnableJpaRepositories("br.com.cadastro.repository")
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
	
}
