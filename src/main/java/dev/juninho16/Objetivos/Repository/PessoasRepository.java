package dev.juninho16.Objetivos.Repository;

import dev.juninho16.Objetivos.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoasRepository extends JpaRepository<PessoaModel ,Long> {
}
