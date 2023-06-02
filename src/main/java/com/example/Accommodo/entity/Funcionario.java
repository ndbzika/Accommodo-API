package com.example.Accommodo.entity;

import com.example.Accommodo.dto.request.FuncionarioRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "id_pessoa")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Funcionario extends Pessoa{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "salario", nullable = false)
    private Double salario;

    @OneToMany(mappedBy = "funcionario")
    private List<Reserva> reservas = new ArrayList<Reserva>();

    public void setReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }
    public void removeReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public Funcionario(FuncionarioRequestDTO data) {
        this.nome = data.nome();
        this.cargo = data.cargo();
        this.salario = data.salario();
    }

    public Map<String,Object> JsonFormat(){
        Map<String,Object>  funcionarioData = new HashMap<String,Object>();
        funcionarioData.put("id", this.id);
        funcionarioData.put("nome", this.nome);
        funcionarioData.put("cargo", this.cargo);
        funcionarioData.put("salario", this.salario);

        return funcionarioData;
    }
}
