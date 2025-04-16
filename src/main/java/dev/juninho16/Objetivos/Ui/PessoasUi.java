package dev.juninho16.Objetivos.Ui;

import dev.juninho16.Objetivos.DTO.ObjetivosDTO;
import dev.juninho16.Objetivos.DTO.PessoaDTO;
import dev.juninho16.Objetivos.Service.ObjetivosService;
import dev.juninho16.Objetivos.Service.PessoaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/pessoa/ui")
public class PessoasUi {
    private final PessoaService pessoaService;
    private final ObjetivosService objetivosService;

    public PessoasUi(PessoaService pessoaService, ObjetivosService objetivosService) {
        this.pessoaService = pessoaService;
        this.objetivosService = objetivosService;
    }

    @GetMapping("/boasVindas")
    public String boasVindas(Model model){
        List<PessoaDTO> pessoas = pessoaService.listarPessoas();
        model.addAttribute("pessoas", pessoas);
        return "boasvindas";
    }

    @GetMapping("/listar")
    public String mostrarTodasPessoas(Model model){
        List<PessoaDTO> pessoas = pessoaService.listarPessoas();
        model.addAttribute("pessoas", pessoas);
        return "listarPessoas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarPessoa(@PathVariable Long id){
        pessoaService.deletarPessoa(id);
        return "redirect:/pessoa/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String mostrarPessoaId(@PathVariable Long id, Model model){
        PessoaDTO pessoaDTO = pessoaService.listarPessoaId(id);

        if(pessoaDTO != null){
            model.addAttribute("pessoas", pessoaDTO);
            return "detalhespessoa";
        } else {
            model.addAttribute("mensagem", "Pessoa não encontrada");
            return "listarPessoas";
        }
    }

    @GetMapping("/criar")
    public String criarPessoa(Model model){
        model.addAttribute("pessoa", new PessoaDTO());

        List<ObjetivosDTO> objetivosDTOS = objetivosService.listarObjetivos();
        model.addAttribute("objetivos", objetivosDTOS);

        return "adicionarpessoa";
    }

    @PostMapping("/salvar")
    public String salvarPessoa(@ModelAttribute PessoaDTO pessoa, RedirectAttributes redirectAttributes) {
        pessoaService.criarPessoa(pessoa);
        redirectAttributes.addFlashAttribute("mensagem", "Pessoa cadastrado com sucesso!");
        return "redirect:/pessoa/ui/listar";
    }
}
