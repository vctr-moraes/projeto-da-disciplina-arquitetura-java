package model.service;

import model.domain.Vendedor;
import model.repository.VendedorRepository;
import model.domain.Endereco;
import clients.IEnderecoClient;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private IEnderecoClient enderecoClient;

    public void incluir(Vendedor vendedor) {
        Endereco endereco = enderecoClient.buscarCep(vendedor.getEndereco().getCep());
        vendedor.setEndereco(endereco);
        vendedorRepository.save(vendedor);
    }

    public Collection<Vendedor> listar(){
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }

    public void excluir(Integer id) {
        vendedorRepository.deleteById(id);
    }

    public long obterQtde() {
        return vendedorRepository.count();
    }
}