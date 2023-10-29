package model.repository;

import model.domain.Eletrodomestico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EletrodomesticoRepository extends CrudRepository<Eletrodomestico, Integer> { }
