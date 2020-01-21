package diegodenzer.com.carros.service;

import diegodenzer.com.carros.domain.Carro;
import diegodenzer.com.carros.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository rep;

    public CarroService(CarroRepository rep) {
        this.rep = rep;
    }

    public Iterable<Carro> getCarros(){
        return rep.findAll();
    }

    public Optional<Carro> obterPorId(String id) {
        return rep.findById(id);
    }

    public  Optional<Carro> obterPorTipo(String tipo) {
        return rep.findByTipo(tipo);
    }

    public  Carro salvar(Carro carro) {
        return rep.save(carro);
    }
}
