package model.service;

import model.domain.Movel;
import model.repository.MovelRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovelService {
    @Autowired
    private MovelRepository movelRepository;

    public void incluir(Movel movel) {
        movelRepository.save(movel);
    }

    public Collection<Movel> listar(){
        return (Collection<Movel>) movelRepository.findAll();
    }

    public long obterQtde() {
        return movelRepository.count();
    }
}