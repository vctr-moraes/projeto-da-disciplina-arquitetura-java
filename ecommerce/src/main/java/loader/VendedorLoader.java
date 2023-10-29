package loader;

import model.domain.Vendedor;
import model.service.VendedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {
    @Autowired
    private VendedorService vendedorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/vendedores.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Vendedor vendedor = new Vendedor();

            vendedor.setId(Integer.parseInt(campos[0]));
            vendedor.setNome(campos[1]);
            vendedor.setDocumento(campos[2]);
            vendedor.setEmail(campos[3]);

            vendedorService.incluir(vendedor);

            linha = leitura.readLine();
        }

        for(Vendedor vendedor: vendedorService.listar()) {
            System.out.println("[Vendedor] " + vendedor);
        }

        leitura.close();
    }
}
