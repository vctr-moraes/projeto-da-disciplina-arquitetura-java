package loader;

import model.domain.Eletrodomestico;
import model.domain.Movel;
import model.domain.Produto;
import model.domain.Vendedor;
import model.service.ProdutoService;
import model.service.VendedorService;

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
	
	@Autowired
	private VendedorService vendedorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/produtos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;
        
        Vendedor vendedor = new Vendedor();

        while (linha != null) {
            campos = linha.split(";");

            switch (campos[8]) {
                case "M" -> {
                    Movel movel = new Movel();
                    movel.setCodigo(Integer.parseInt(campos[0]));
                    movel.setNome(String.valueOf(campos[1]));
                    movel.setDescricao(campos[2]);
                    movel.setPreco(Float.parseFloat(campos[3]));
                    movel.setEstoque(Boolean.parseBoolean(campos[4]));
                    movel.setDataCadastro(new Date(campos[5]));
                    movel.setTempoGarantia(Integer.parseInt(campos[6]));

                    vendedor.setId(Integer.valueOf(campos[8]));
                    movel.setVendedor(vendedor);
                    produtoService.incluir(movel);
                    break;
                }
                case "E" -> {
                    Eletrodomestico eletrodomestico = new Eletrodomestico();
                    eletrodomestico.setCodigo(Integer.parseInt(campos[0]));
                    eletrodomestico.setNome(campos[1]);
                    eletrodomestico.setDescricao(campos[2]);
                    eletrodomestico.setPreco(Float.parseFloat(campos[3]));
                    eletrodomestico.setEstoque(Boolean.parseBoolean(campos[4]));
                    eletrodomestico.setDataCadastro(new Date(campos[5]));
                    eletrodomestico.setTempoGarantia(Integer.parseInt(campos[6]));

                    vendedor.setId(Integer.valueOf(campos[8]));
                    eletrodomestico.setVendedor(vendedor);
                    produtoService.incluir(eletrodomestico);
                    break;
                }
                default -> {
                    break;
                }
            }

            linha = leitura.readLine();
        }

        for(Vendedor vend : vendedorService.listar()) {
            for(Produto produto : produtoService.listar(vend)) {
                System.out.println("[Produto] " + produto);
            }
        }

        leitura.close();
    }
}