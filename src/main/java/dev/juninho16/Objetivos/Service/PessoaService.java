package dev.juninho16.Objetivos.Service;


import dev.juninho16.Objetivos.DTO.PessoaDTO;
import dev.juninho16.Objetivos.Mapper.PessoaMapper;
import dev.juninho16.Objetivos.Model.PessoaModel;
import dev.juninho16.Objetivos.Repository.PessoasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoasRepository pessoasRepository;
    private PessoaMapper pessoaMapper;

    public PessoaService(PessoasRepository pessoasRepository, PessoaMapper pessoaMapper) {
        this.pessoasRepository = pessoasRepository;
        this.pessoaMapper = pessoaMapper;
    }

    //Listar todas as pessoas
    public List<PessoaDTO> listarPessoas(){
        List<PessoaModel> pessoas = pessoasRepository.findAll();
        return pessoas.stream()
                .map(pessoaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar pessoa por ID
    public PessoaDTO listarPessoaId(Long id){
        Optional<PessoaModel> pesssoaByid = pessoasRepository.findById(id);
        return pesssoaByid.map(pessoaMapper::map).orElse(null);
    }

    //Criar pessoa
    public PessoaDTO criarPessoa(PessoaDTO pessoaDTO){
        PessoaModel pessoa = pessoaMapper.map(pessoaDTO);
        pessoa = pessoasRepository.save(pessoa);
        return  pessoaMapper.map(pessoa);
    }

    //Deletar Pessoa
    public void deletarPessoa(Long id){
        pessoasRepository.deleteById(id);
    }

    //Alterar Pessoa
    public PessoaDTO atualizarPessoa(Long id, PessoaDTO pessoaDTO){
        Optional<PessoaModel> pessoaExist = pessoasRepository.findById(id);
        if (pessoaExist.isPresent()){
            PessoaModel pessoaAtt = pessoaMapper.map(pessoaDTO);
            pessoaAtt.setId(id);
            PessoaModel pessoaSalva = pessoasRepository.save(pessoaAtt);
            return  pessoaMapper.map(pessoaSalva);
        }
        return null;
    }
}
