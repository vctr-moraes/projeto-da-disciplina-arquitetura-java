package model.service;

import model.domain.Produto;
import model.domain.Vendedor;
import model.repository.ProdutoRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void incluir(Produto produto) {
        produtoRepository.save(produto);
    }

    public Collection<Produto> listar(){
        return (Collection<Produto>) produtoRepository.findAll();
    }

    public Collection<Produto> listar(Vendedor vendedor){
        return (Collection<Produto>) produtoRepository.listar(vendedor.getId());
    }

    public Collection<Produto> listar(Integer id){
        return (Collection<Produto>) produtoRepository.listar(id);
    }

    public long obterQtde() {
        return produtoRepository.count();
    }
}