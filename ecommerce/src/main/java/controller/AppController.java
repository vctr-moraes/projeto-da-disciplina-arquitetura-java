package controller;

import model.service.MovelService;
import model.service.EletrodomesticoService;
import model.service.ProdutoService;
import model.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    private VendedorService vendedorService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private MovelService movelService;

    @Autowired
    private EletrodomesticoService eletrodomesticoService;

    @GetMapping(value = "/")
    public String showHome(Model model) {
        model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
        model.addAttribute("qtdeProduto", produtoService.obterQtde());
        model.addAttribute("qtdeMovel", movelService.obterQtde());
        model.addAttribute("qtdeEletrodomestico", eletrodomesticoService.obterQtde());

        return "home";
    }

    @GetMapping(value = "/produto/lista")
    public String obterListaProduto(Model model) {
        model.addAttribute("titulo", "Produtos:");
        model.addAttribute("listagem", produtoService.listar());

        return showHome(model);
    }

    @GetMapping(value = "/movel/lista")
    public String obterListaMovel(Model model) {
        model.addAttribute("titulo", "Produtos móveis:");
        model.addAttribute("listagem", movelService.listar());

        return showHome(model);
    }

    @GetMapping(value = "/eletrodomestico/lista")
    public String obterListaEletrodomestico(Model model) {
        model.addAttribute("titulo", "Produtos eletrodomésticos:");
        model.addAttribute("listagem", eletrodomesticoService.listar());

        return showHome(model);
    }
}