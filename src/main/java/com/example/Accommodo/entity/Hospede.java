package com.example.Accommodo.entity;

import com.example.Accommodo.dto.request.HospedeRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "hospede")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hospede extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Hospede(HospedeRequestDTO data) {
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();
    }

    public Map<String,Object> JsonFormat(){
        Map<String,Object> hospedeData = new HashMap<String,Object>();
        hospedeData.put("id", this.id);
        hospedeData.put("nome", this.nome);
        hospedeData.put("email", this.email);
        hospedeData.put("telefone", this.telefone);

        return hospedeData;
    }

}
