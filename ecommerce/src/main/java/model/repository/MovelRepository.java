package model.repository;

import model.domain.Movel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovelRepository extends CrudRepository<Movel, Integer> { }
