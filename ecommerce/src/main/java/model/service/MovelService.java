package model.service;

import model.domain.Movel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MovelService {
    private Map<Integer, Movel> movelMap = new HashMap<Integer, Movel>();

    public void incluir(Movel movel) {
        movelMap.put(movel.getCodigo(), movel);
    }

    public Collection<Movel> listar(){
        return movelMap.values();
    }
}
