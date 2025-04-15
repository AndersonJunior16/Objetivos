package dev.juninho16.Objetivos.Controller;

import dev.juninho16.Objetivos.DTO.ObjetivosDTO;
import dev.juninho16.Objetivos.Service.ObjetivosService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("objetivos")
public class ObjetivosController {

    private ObjetivosService objetivosService;

    public ObjetivosController(ObjetivosService objetivosService) {
        this.objetivosService = objetivosService;
    }

    //GET
    @GetMapping("/listar")
    public ResponseEntity<List<ObjetivosDTO>> listarObjetivos(){
        List<ObjetivosDTO> objetivosDTOS = objetivosService.listarObjetivos();
        return  ResponseEntity.ok(objetivosDTOS);
    }

    //GET
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostraObjetivoId(@PathVariable Long id){
        ObjetivosDTO objetivos = objetivosService.listarObjetivoPorId(id);

        if (objetivos != null){
            return  ResponseEntity.ok(objetivos);
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Objetivo de Id: " + id + "não existe");
        }
    }

    @PostMapping("/criar")
    public  ResponseEntity<String> criarObjetivo(@RequestBody ObjetivosDTO objetivos){
        ObjetivosDTO objetivosDTO = objetivosService.criarObjetivo(objetivos);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Objetivo de nome: " + objetivosDTO.getNome() + " - ID: " + objetivos.getId() + " criado com sucesso");
    }

    //PUT
    @PutMapping("/alterar/{id}")
    public  ResponseEntity<String> alterarObjetivo(@PathVariable Long id, @RequestBody ObjetivosDTO objetivosAtt){
        if (objetivosService.listarObjetivoPorId(id) != null){
            objetivosService.atualizarObjetivo(id, objetivosAtt);
            return ResponseEntity.ok("Objetivo de id: " + id + " alterado com sucesso");
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O objetivo de id: " + id + " não existe");
        }
    }

    //DELETE
    @DeleteMapping("/deletar/{id}")
    public  ResponseEntity<String> deletarObjetivo(@PathVariable Long id){
        if (objetivosService.listarObjetivoPorId(id) != null){
            objetivosService.deletarObjetivo(id);
            return ResponseEntity.ok("Objetivo de ID: " + id + " deletado com sucesso");
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Objetivo de id: " + id + " não existe");
        }
    }
}
