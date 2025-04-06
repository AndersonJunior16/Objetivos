package dev.juninho16.Objetivos.Repository;

import dev.juninho16.Objetivos.Model.ObjetivosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObjetivosRepository extends JpaRepository<ObjetivosModel, Long> {
}
