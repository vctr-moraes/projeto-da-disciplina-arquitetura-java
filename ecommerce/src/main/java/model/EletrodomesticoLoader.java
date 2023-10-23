package model;

import model.domain.Eletrodomestico;
import model.service.EletrodomesticoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

public class EletrodomesticoLoader implements ApplicationRunner {
    @Autowired
    private EletrodomesticoService eletrodomesticoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileReader file = new FileReader("files/eletrodomesticos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos = null;

        while(linha != null) {
            campos = linha.split(";");

            Eletrodomestico eletrodomestico = new Eletrodomestico();

            eletrodomestico.setCodigo(Integer.parseInt(campos[0]));
            eletrodomestico.setNome(campos[1]);
            eletrodomestico.setDescricao(campos[2]);
            eletrodomestico.setPreco(Float.parseFloat(campos[3]));
            eletrodomestico.setEstoque(Boolean.parseBoolean(campos[4]));
            eletrodomestico.setDataCadastro(new Date(campos[5]));
            eletrodomestico.setTempoGarantia(Integer.parseInt(campos[6]));

            eletrodomesticoService.incluir(eletrodomestico);
            linha = leitura.readLine();
        }

        for(Eletrodomestico eletrodomestico : eletrodomesticoService.listar()) {
            System.out.println("[Eletrodoméstico] " + eletrodomestico);
        }

        leitura.close();
    }
}
