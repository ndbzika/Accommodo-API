package com.example.Accommodo.entity;

import com.example.Accommodo.dto.request.ReservaRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @ManyToOne
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;

    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "data_fim", nullable = false)
    private Date dataFim;

    @Column(name = "status")
    private String status;


    public Reserva(ReservaRequestDTO data) throws ParseException {
        this.hospede = data.hospede();
        this.quarto = data.quarto();
        this.status = data.status();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.dataInicio = sdf.parse(data.dataInicio());
        this.dataFim = sdf.parse(data.dataFim());
    }

    public Map<String,Object> JsonFormat(){
        Map<String,Object>  reservaData = new HashMap<String,Object>();
        reservaData.put("id", this.id);
        reservaData.put("hospede_id", this.hospede);
        reservaData.put("quarto_id", this.quarto);
        reservaData.put("id_funcioario", this.funcionario);
        reservaData.put("data_inicio", this.dataInicio);
        reservaData.put("dataFim", this.dataFim);
        reservaData.put("status", this.status);

        return reservaData;
    }
}
