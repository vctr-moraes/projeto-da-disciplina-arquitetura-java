package controller;

import model.domain.Informacao;
import model.service.InformacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InformacaoController {
    @Autowired
    private InformacaoService informacaoService;

    @PostMapping(value = "/informacao/incluir")
    public String incluir(Informacao informacao) {
        Informacao result = informacaoService.incluir(informacao);
        System.out.println("Result: " + result);

        return "redirect:/";
    }
}