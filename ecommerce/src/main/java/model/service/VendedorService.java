package model.service;

import model.domain.Vendedor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class VendedorService {
    private Map<String, Vendedor> vendedorMap = new HashMap<String, Vendedor>();

    public void incluir(Vendedor vendedor) {
        vendedorMap.put(vendedor.getDocumento(), vendedor);
    }

    public Collection<Vendedor> listar(){
        return vendedorMap.values();
    }
}
