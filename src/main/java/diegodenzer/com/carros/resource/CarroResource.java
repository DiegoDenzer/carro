package diegodenzer.com.carros.resource;

import diegodenzer.com.carros.domain.Carro;
import diegodenzer.com.carros.dto.CarroDTO;
import diegodenzer.com.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carro")
public class CarroResource {

    @Autowired
    private CarroService service;

    @GetMapping
    public List<CarroDTO> carros(){

        return service.getCarros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroDTO> obter(@PathVariable String id) {
        return service.obterPorId(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable String id, @RequestBody Carro carro) {
        Carro carroAtualizado = service.atualizar(carro, id);
        return  ResponseEntity.ok().body(carroAtualizado);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<CarroDTO>> obterPorTipo(@PathVariable String tipo) {
        List<CarroDTO> carros = service.obterPorTipo(tipo);
        return carros.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(carros);
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

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id){
        service.delete(id);
        return "Carro deletado";
    }

}
