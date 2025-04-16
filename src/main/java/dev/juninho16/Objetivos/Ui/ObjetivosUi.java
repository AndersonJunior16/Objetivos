package dev.juninho16.Objetivos.Ui;


import dev.juninho16.Objetivos.DTO.ObjetivosDTO;
import dev.juninho16.Objetivos.Model.ObjetivosModel;
import dev.juninho16.Objetivos.Service.ObjetivosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/objetivos/ui")
public class ObjetivosUi {

    private final ObjetivosService objetivoService;

    public ObjetivosUi(ObjetivosService objetivoService) {
        this.objetivoService = objetivoService;
    }

    @GetMapping("/listar")
    public String listarObjetivos(Model model) {
        List<ObjetivosDTO> objetivos = objetivoService.listarObjetivos();
        model.addAttribute("objetivos", objetivos);
        return "listarObjetivos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarObjetivo(@PathVariable Long id) {
        objetivoService.deletarObjetivo(id);
        return "redirect:/objetivos/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String buscarPorId(@PathVariable Long id, Model model) {
        ObjetivosDTO objetivo = objetivoService.listarObjetivoPorId(id);
        if (objetivo != null) {
            model.addAttribute("objetivo", objetivo);
            return "detalhesObjetivo";
        } else {
            model.addAttribute("mensagem", "Objetivo não encontrado");
            return "listarObjetivos";
        }
    }

    @GetMapping("/criar")
    public String criarObjetivo(Model model) {
        model.addAttribute("objetivo", new ObjetivosDTO());
        return "adicionarObjetivo";
    }

    @PostMapping("/salvar")
    public String salvarObjetivo(@ModelAttribute ObjetivosDTO objetivoDTO, RedirectAttributes redirectAttributes) {
        objetivoService.criarObjetivo(objetivoDTO);
        redirectAttributes.addFlashAttribute("mensagem", "Objetivo cadastrado com sucesso!");
        return "redirect:/objetivos/ui/listar";
    }
}
