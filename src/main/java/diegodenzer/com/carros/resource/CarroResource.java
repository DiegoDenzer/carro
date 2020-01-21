package diegodenzer.com.carros.resource;

import diegodenzer.com.carros.domain.Carro;
import diegodenzer.com.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carro")
public class CarroResource {

    @Autowired
    private CarroService service;

    @GetMapping
    public Iterable<Carro> carros(){

        return service.getCarros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> obter(@PathVariable String id) {
        Optional<Carro> opt = service.obterPorId(id);
        return opt.isPresent() ? ResponseEntity.ok().body(opt.get()) : ResponseEntity.notFound().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<Carro> obterPorTipo(@PathVariable String tipo) {
        Optional<Carro> opt = service.obterPorTipo(tipo);
        return opt.isPresent() ? ResponseEntity.ok().body(opt.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public String  criar(@RequestBody Carro carro) {
        try {
            Carro carroSalvo = service.salvar(carro);
           // URI location = new URI("api/v1/carro/"+carroSalvo.getId());
            return "Carro salvo com sucesso "  + carroSalvo.getId();
        } catch (Exception e) {
            return  "erro";
        }
    }

}
