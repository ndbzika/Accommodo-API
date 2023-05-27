package com.example.Accommodo.entity;

import com.example.Accommodo.dto.request.ReservaRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "reserva")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "hospede_id", referencedColumnName = "id")
    private Hospede hospede;

    @ManyToOne
    @JoinColumn(name = "quarto_id", referencedColumnName = "id")
    private Quarto quarto;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Reserva(ReservaRequestDTO data) {
        this.hospede = data.hospede();
        this.quarto = data.quarto();
        this.funcionario = data.funcionario();
        this.status = data.status();
        this.dataInicio = data.dataInicio();
        this.dataFim = data.dataFim();
    }

    public Map<String,Object> JsonFormat(){
        Map<String,Object>  reservaData = new HashMap<String,Object>();
        reservaData.put("id", this.id);
        reservaData.put("hospede_id", this.hospede.getId());
        reservaData.put("quarto_id", this.quarto.getId());
        reservaData.put("funcionario_id", this.funcionario.getId());
        reservaData.put("data_inicio", this.dataInicio);
        reservaData.put("dataFim", this.dataFim);
        reservaData.put("status", this.status);

        return reservaData;
    }
}
