package dev.juninho16.Objetivos.Mapper;

import dev.juninho16.Objetivos.DTO.ObjetivosDTO;
import dev.juninho16.Objetivos.Model.ObjetivosModel;
import dev.juninho16.Objetivos.Model.PessoaModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjetivosMapper {

    public ObjetivosModel map(ObjetivosDTO objetivosDTO){
        ObjetivosModel objetivosModel = new ObjetivosModel();
        objetivosModel.setId(objetivosDTO.getId());
        objetivosModel.setNome(objetivosDTO.getNome());
        objetivosModel.setPrazo(objetivosDTO.getPrazo());
        objetivosModel.setPessoas(objetivosDTO.getPessoas());
        objetivosModel.setDescricao(objetivosDTO.getDescricao());

        return objetivosModel;
    }

    public ObjetivosDTO map(ObjetivosModel objetivosModel){
        ObjetivosDTO objetivosDTO = new ObjetivosDTO();
        objetivosDTO.setId(objetivosModel.getId());
        objetivosDTO.setNome(objetivosModel.getNome());
        objetivosDTO.setPrazo(objetivosModel.getPrazo());
        objetivosDTO.setPessoas(objetivosModel.getPessoas());
        objetivosDTO.setDescricao(objetivosModel.getDescricao());

        return objetivosDTO;
    }
}
