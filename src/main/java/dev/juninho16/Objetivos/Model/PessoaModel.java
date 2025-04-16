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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public ObjetivosModel getObjetivosModel() {
        return objetivosModel;
    }

    public void setObjetivosModel(ObjetivosModel objetivosModel) {
        this.objetivosModel = objetivosModel;
    }
}
