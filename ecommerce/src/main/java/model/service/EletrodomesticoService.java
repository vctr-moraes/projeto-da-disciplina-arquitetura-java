package model.service;

import model.domain.Eletrodomestico;
import java.util.Collection;
import model.repository.EletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EletrodomesticoService {
    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;

    public void incluir(Eletrodomestico eletrodomestico) {
        eletrodomesticoRepository.save(eletrodomestico);
    }

    public Collection<Eletrodomestico> listar(){
        return (Collection<Eletrodomestico>) eletrodomesticoRepository.findAll();
    }
}
