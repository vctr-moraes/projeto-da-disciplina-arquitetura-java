package controller;

import model.service.VendedorService;
import model.domain.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VendedorController {
    @Autowired
    private AppController appController;

    @Autowired
    private VendedorService vendedorService;

    @GetMapping(value = "/vendedor/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        vendedorService.excluir(id);
        return "redirect:/vendedor/lista";
    }

    @GetMapping(value = "/vendedor/lista")
    public String obterLista(Model model) {
        model.addAttribute("rota", "vendedor");
        model.addAttribute("titulo", "Vendedores:");
        model.addAttribute("listagem", vendedorService.listar());

        return appController.showHome(model);
    }

    @GetMapping(value = "/vendedor/pesquisar")
    public String pesquisar(Model model, String campoBusca) {
        Vendedor vendedor = vendedorService.pesquisar(campoBusca);

        if(vendedor != null) {
            model.addAttribute("objeto", vendedor);
            return appController.showHome(model);
        }

        return "redirect:/vendedor/lista";
    }
}