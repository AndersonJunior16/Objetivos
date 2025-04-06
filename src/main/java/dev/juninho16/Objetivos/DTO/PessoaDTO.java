package dev.juninho16.Objetivos.DTO;

import dev.juninho16.Objetivos.Model.ObjetivosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private String email;
    private Long telefone;
    private String cpf;
    private ObjetivosModel objetivosModel;
    private int idade;

}
