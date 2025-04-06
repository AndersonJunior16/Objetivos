package dev.juninho16.Objetivos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private Long telefone;

    @Column(unique = true)
    private String cpf;

    @Column(name = "idade")
    private int idade;


    //@ManyToOne: um ninja tem uma unica missão
    @ManyToOne
    @JoinColumn(name = "objetivos_id") //foreing Key
    private ObjetivosModel objetivosModel;

}
