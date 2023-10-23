package model.service;

import model.domain.Produto;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private Map<Integer, Produto> produtoMap = new HashMap<Integer, Produto>();

    public void incluir(Produto produto) {
        produtoMap.put(produto.getCodigo(), produto);
    }

    public Collection<Produto> listar(){
        return produtoMap.values();
    }
}
