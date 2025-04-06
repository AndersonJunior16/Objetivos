package dev.juninho16.Objetivos.Mapper;

import dev.juninho16.Objetivos.DTO.PessoaDTO;
import dev.juninho16.Objetivos.Model.PessoaModel;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public PessoaModel map(PessoaDTO pessoaDTO){
        PessoaModel pessoaModel = new PessoaModel();
        pessoaModel.setId((pessoaDTO.getId()));
        pessoaModel.setNome(pessoaDTO.getNome());
        pessoaModel.setIdade(pessoaDTO.getIdade());
        pessoaModel.setCpf(pessoaDTO.getCpf());
        pessoaModel.setEmail(pessoaDTO.getEmail());
        pessoaModel.setTelefone(pessoaDTO.getTelefone());
        pessoaModel.setObjetivosModel(pessoaDTO.getObjetivosModel());
        return pessoaModel;
    }

    public PessoaDTO map(PessoaModel pessoaModel){

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoaModel.getId());
        pessoaDTO.setCpf(pessoaModel.getCpf());
        pessoaDTO.setTelefone(pessoaModel.getTelefone());
        pessoaDTO.setNome(pessoaModel.getNome());
        pessoaDTO.setIdade(pessoaModel.getIdade());
        pessoaDTO.setEmail(pessoaModel.getEmail());
        pessoaDTO.setObjetivosModel(pessoaModel.getObjetivosModel());
        return pessoaDTO;
    }

}
