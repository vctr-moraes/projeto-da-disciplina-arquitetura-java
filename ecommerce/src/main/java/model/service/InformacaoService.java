package model.service;

import clients.IInformacaoClient;
import model.domain.Informacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InformacaoService {
    @Autowired
    private IInformacaoClient informacaoClient;

    public List<Informacao> listar(){
        return informacaoClient.listar();
    }

    public Informacao incluir(Informacao informacao) {
        return informacaoClient.incluir(informacao);
    }
}