package loader;

import model.domain.Movel;
import model.service.MovelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

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

            movel.setId(Integer.parseInt(campos[0]));
            movel.setCodigo(Integer.parseInt(campos[1]));
            movel.setNome(String.valueOf(campos[2]));
            movel.setDescricao(campos[3]);
            movel.setPreco(Float.parseFloat(campos[4]));
            movel.setEstoque(Boolean.parseBoolean(campos[5]));
            movel.setDataCadastro(new Date(campos[6]));
            movel.setTempoGarantia(Integer.parseInt(campos[7]));

            movelService.incluir(movel);
            linha = leitura.readLine();
        }

        for(Movel movel : movelService.listar()) {
            System.out.println("[Móvel] " + movel);
        }

        leitura.close();
    }
}
