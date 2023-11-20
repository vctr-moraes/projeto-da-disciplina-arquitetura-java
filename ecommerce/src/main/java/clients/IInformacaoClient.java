package clients;

import model.domain.Informacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@FeignClient(url = "http://localhost:8081/api/informacao", name = "informacaoClient")
public interface IInformacaoClient {
    @GetMapping(value = "/lista")
    public List<Informacao> listar();

    @PostMapping(value = "/incluir")
    public Informacao incluir(Informacao informacao);
}