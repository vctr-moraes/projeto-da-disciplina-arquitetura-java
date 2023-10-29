package model.service;

import model.domain.Produto;
import java.util.Collection;
import model.repository.ProdutoRepository;
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
}
