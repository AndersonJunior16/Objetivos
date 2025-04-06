package dev.juninho16.Objetivos.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.juninho16.Objetivos.Model.PessoaModel;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetivosDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime prazo;
    private List<PessoaModel> pessoas;

}
