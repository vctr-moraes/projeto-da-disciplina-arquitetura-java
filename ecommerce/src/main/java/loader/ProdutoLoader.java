package loader;

import model.domain.Eletrodomestico;
import model.domain.Movel;
import model.domain.Produto;
import model.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {
    @Autowired
    private ProdutoService produtoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/produtos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        while (linha != null) {
            campos = linha.split(";");

            switch (campos[8]) {
                case "A" -> {
                    Movel movel = new Movel();
                    movel.setId(Integer.parseInt(campos[0]));
                    movel.setCodigo(Integer.parseInt(campos[1]));
                    movel.setNome(String.valueOf(campos[2]));
                    movel.setDescricao(campos[3]);
                    movel.setPreco(Float.parseFloat(campos[4]));
                    movel.setEstoque(Boolean.parseBoolean(campos[5]));
                    movel.setDataCadastro(new Date(campos[6]));
                    movel.setTempoGarantia(Integer.parseInt(campos[7]));
                    produtoService.incluir(movel);
                }
                case "E" -> {
                    Eletrodomestico eletrodomestico = new Eletrodomestico();
                    eletrodomestico.setId(Integer.parseInt(campos[0]));
                    eletrodomestico.setCodigo(Integer.parseInt(campos[1]));
                    eletrodomestico.setNome(campos[2]);
                    eletrodomestico.setDescricao(campos[3]);
                    eletrodomestico.setPreco(Float.parseFloat(campos[4]));
                    eletrodomestico.setEstoque(Boolean.parseBoolean(campos[5]));
                    eletrodomestico.setDataCadastro(new Date(campos[6]));
                    eletrodomestico.setTempoGarantia(Integer.parseInt(campos[7]));
                    produtoService.incluir(eletrodomestico);
                }
                default -> {
                }
            }

            linha = leitura.readLine();
        }

        for(Produto produto: produtoService.listar()) {
            System.out.println("[Produto] " + produto);
        }

        leitura.close();
    }
}
