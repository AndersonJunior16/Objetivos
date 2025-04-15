package dev.juninho16.Objetivos.Controller;


import dev.juninho16.Objetivos.DTO.PessoaDTO;
import dev.juninho16.Objetivos.Service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pessoas")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }


    //Create
    @PostMapping("/criar")
    public ResponseEntity<String> criarPessoa(@RequestBody PessoaDTO pessoa){
        PessoaDTO pessoaDTO = pessoaService.criarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Pessoa criada com sucesso - NOME: " + pessoaDTO.getNome() + "Id: " + pessoaDTO.getId());
    }

    //Read
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarPessoaId(@PathVariable Long id){
        PessoaDTO pessoa = pessoaService.listarPessoaId(id);

        if (pessoa != null){
            return  ResponseEntity.ok(pessoa);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A pessoa de ID: " + id + "não foi encontrada!");
        }
    }

    //Read
    @GetMapping("/listar")
    public ResponseEntity<List<PessoaDTO>> mostrarPessoas(){
        List<PessoaDTO> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    //Uptade
    @PutMapping("alterar/{id}")
    public ResponseEntity<String> alterarPessoa(@PathVariable Long id, @RequestBody PessoaDTO pessoaDTO){
        if (pessoaService.listarPessoaId(id) != null){
            pessoaService.atualizarPessoa(id, pessoaDTO);
            return ResponseEntity.ok("Pessoa ID: " + id + "Atualiazada" );
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A pessoa de ID: " + id + " não existe");
        }
    }

    //Delete
    public ResponseEntity<String> deletarPessoa(@PathVariable Long id){
        if (pessoaService.listarPessoaId(id) != null){
            pessoaService.deletarPessoa(id);
            return  ResponseEntity.ok("Pessoa Id: " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A pessoa de ID: " + id + "não existe");
        }
    }

}
