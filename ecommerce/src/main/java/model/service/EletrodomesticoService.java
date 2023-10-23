package model.service;

import model.domain.Eletrodomestico;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EletrodomesticoService {
    private Map<Integer, Eletrodomestico> eletrodomesticoMap = new HashMap<Integer, Eletrodomestico>();

    public void incluir(Eletrodomestico eletrodomestico) {
        eletrodomesticoMap.put(eletrodomestico.getCodigo(), eletrodomestico);
    }

    public Collection<Eletrodomestico> listar(){
        return eletrodomesticoMap.values();
    }
}
