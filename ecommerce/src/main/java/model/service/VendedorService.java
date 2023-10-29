package model.service;

import java.util.Collection;
import model.domain.Vendedor;
import model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    public void incluir(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    public Collection<Vendedor> listar(){
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }
}
