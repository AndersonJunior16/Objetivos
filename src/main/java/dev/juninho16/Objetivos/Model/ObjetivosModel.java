package dev.juninho16.Objetivos.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_objetivos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ObjetivosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private LocalDateTime prazo;

    @OneToMany(mappedBy = "objetivos")
    @JsonIgnore
    private List<PessoaModel> pessoas;


}
