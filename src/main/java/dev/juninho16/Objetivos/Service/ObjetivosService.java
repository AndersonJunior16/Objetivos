package dev.juninho16.Objetivos.Service;


import dev.juninho16.Objetivos.DTO.ObjetivosDTO;
import dev.juninho16.Objetivos.Mapper.ObjetivosMapper;
import dev.juninho16.Objetivos.Model.ObjetivosModel;
import dev.juninho16.Objetivos.Repository.ObjetivosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ObjetivosService {

    private ObjetivosRepository objetivosRepository;
    private ObjetivosMapper objetivosMapper;

    public ObjetivosService(ObjetivosRepository objetivosRepository, ObjetivosMapper objetivosMapper) {
        this.objetivosRepository = objetivosRepository;
        this.objetivosMapper = objetivosMapper;
    }

    //listar todas as missões
    public List<ObjetivosDTO> listarObjetivos(){
        List<ObjetivosModel> objetivos = objetivosRepository.findAll();
        return objetivos.stream()
                .map(objetivosMapper::map)
                .collect(Collectors.toList());
    }

    //listar Objetivo por id
    public ObjetivosDTO listarObjetivoPorId(Long id){
        Optional<ObjetivosModel> objetivosPorId = objetivosRepository.findById(id);
        return  objetivosPorId.map(objetivosMapper::map).orElse(null);
    }

    //Criar novo Objetivo
    public ObjetivosDTO criarObjetivo(ObjetivosDTO objetivosDTO){
        ObjetivosModel objetivos = objetivosMapper.map(objetivosDTO);
        objetivos = objetivosRepository.save(objetivos);
        return  objetivosMapper.map(objetivos);
    }

    //deletar Objetivo
    public void deletarObjetivo(Long id){
        objetivosRepository.deleteById(id);
    }

    //Alterar Objetivo
    public ObjetivosDTO atualizarObjetivo(Long id, ObjetivosDTO objetivosDTO){
        Optional<ObjetivosModel> objetivosExist = objetivosRepository.findById(id);
        if(objetivosExist.isPresent()){
            ObjetivosModel objetivoAtt = objetivosMapper.map(objetivosDTO);
            objetivoAtt.setId(id);
            ObjetivosModel objetivoSalvo = objetivosRepository.save(objetivoAtt);
            return objetivosMapper.map(objetivoSalvo);
        }
        return null;

    }
}
