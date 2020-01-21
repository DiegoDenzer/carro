package diegodenzer.com.carros.repository;

import diegodenzer.com.carros.domain.Carro;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarroRepository extends CrudRepository<Carro, String> {
    Optional<Carro> findByTipo(String tipo);
}