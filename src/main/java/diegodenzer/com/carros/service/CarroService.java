package diegodenzer.com.carros.service;

import diegodenzer.com.carros.domain.Carro;
import diegodenzer.com.carros.dto.CarroDTO;
import diegodenzer.com.carros.repository.CarroRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {

    private final CarroRepository rep;

    public CarroService(CarroRepository rep) {
        this.rep = rep;
    }

    public List<CarroDTO> getCarros(){
        return rep.findAll().stream()
                .map(CarroDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<CarroDTO> obterPorId(String id) {
        return rep.findById(id).map(CarroDTO::new);
    }

    public List<CarroDTO> obterPorTipo(String tipo) {
        return rep.findByTipo(tipo).stream()
                .map(CarroDTO::new)
                .collect(Collectors.toList());
    }

    public  Carro salvar(Carro carro) {
        return rep.save(carro);
    }
    public Carro atualizar(Carro carro, String id) {
        Assert.notNull(id, "Id vazio");
        return rep.findById(id).map(db -> {
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            rep.save(db);
            return db;
        }).orElseThrow(() -> new RuntimeException("Não foi possivel atualizar o registro!"));
    }

    public void delete(String id) {
         rep.deleteById(id);
    }
}
