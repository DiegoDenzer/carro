package diegodenzer.com.carros.repository;

import diegodenzer.com.carros.domain.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, String> {
    List<Carro> findByTipo(String tipo);
}