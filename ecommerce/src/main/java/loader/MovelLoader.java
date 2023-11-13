package loader;

import model.domain.Movel;
import model.domain.Vendedor;
import model.service.MovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

@Order(3)
@Component
public class MovelLoader implements ApplicationRunner {
    @Autowired
    private MovelService movelService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/moveis.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Movel movel = new Movel();

            movel.setCodigo(Integer.parseInt(campos[0]));
            movel.setNome(String.valueOf(campos[1]));
            movel.setDescricao(campos[2]);
            movel.setPreco(Float.parseFloat(campos[3]));
            movel.setEstoque(Boolean.parseBoolean(campos[4]));
            movel.setDataCadastro(new Date(campos[5]));
            movel.setTempoGarantia(Integer.parseInt(campos[6]));

			Vendedor vendedor = new Vendedor();
			vendedor.setId(Integer.valueOf(campos[7]));
            movel.setVendedor(vendedor);

            movelService.incluir(movel);
            linha = leitura.readLine();
        }

        for(Movel movel : movelService.listar()) {
            System.out.println("[Móvel] " + movel);
        }

        leitura.close();
    }
}