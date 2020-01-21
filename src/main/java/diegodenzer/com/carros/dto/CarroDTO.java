package diegodenzer.com.carros.dto;


import diegodenzer.com.carros.domain.Carro;
import lombok.Data;

@Data
public class CarroDTO {

    private String id;
    private String nome;
    private String urlFoto;
    private String tipo;

    public CarroDTO(Carro c) {
        this.id = c.getId();
        this.nome = c.getNome();
        this.urlFoto = c.getUrlFoto();
        this.tipo =c. getTipo();
    }

}
