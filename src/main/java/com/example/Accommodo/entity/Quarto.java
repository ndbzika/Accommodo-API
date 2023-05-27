package com.example.Accommodo.entity;

import com.example.Accommodo.dto.request.QuartoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "quarto")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "preco", nullable = false)
    private Double preco;

    @Column(name = "status", nullable = false)
    private String status;

    public Quarto(QuartoRequestDTO data) {
        this.numero = data.numero();
        this.tipo = data.tipo();
        this.preco = data.preco();
        this.status = data.status();
    }

    public Map<String,Object> JsonFormat(){
        Map<String,Object>  quartoData = new HashMap<String,Object>();
        quartoData.put("id", this.id);
        quartoData.put("numero", this.numero);
        quartoData.put("tipo", this.tipo);
        quartoData.put("preco", this.preco);
        quartoData.put("status", this.status);

        return quartoData;
    }
}
