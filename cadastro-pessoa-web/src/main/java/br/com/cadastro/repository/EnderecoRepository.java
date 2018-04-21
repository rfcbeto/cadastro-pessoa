package br.com.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import br.com.cadastro.model.Endereco;

@Repository
@EnableJpaRepositories("br.com.cadastro.repository")
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	@Query("SELECT e FROM Pessoa p, Endereco e WHERE p.nome = ?1 "
			+ "and p.id = e.pessoa AND e.tipoEndereco in (1, 3)")
	public List<Endereco> getEnderecoByNomePessoa(String nome);
}
