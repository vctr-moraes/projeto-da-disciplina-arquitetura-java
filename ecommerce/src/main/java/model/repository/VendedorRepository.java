package model.repository;

import model.domain.Vendedor;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {
    Vendedor findByCpf(String cpf);

    List<Vendedor> findAll(Sort sort);
}