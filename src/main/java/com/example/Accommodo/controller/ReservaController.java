package com.example.Accommodo.controller;

import com.example.Accommodo.dto.request.ReservaRequestDTO;
import com.example.Accommodo.dto.response.ReservaResponseDTO;
import com.example.Accommodo.entity.Reserva;
import com.example.Accommodo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "reservas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservaController {

    @Autowired
    private ReservaRepository repository;

    @PostMapping
    public ResponseEntity<Map<String, Object>> store(@RequestBody ReservaRequestDTO data) {
        if (data.dataFim().isBefore(data.dataInicio())) return ResponseEntity.badRequest().build();
        Reserva reserva = new Reserva(data);
        repository.save(reserva);

        return ResponseEntity.ok(reserva.JsonFormat());
    }

    @GetMapping
    public List<ReservaResponseDTO> index() {
        List<ReservaResponseDTO> reservaList = repository.findAll().stream().map(ReservaResponseDTO::new).toList();
        return reservaList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> show(@PathVariable("id") Integer id) {
        Optional<Reserva> reservaOptional = repository.findById(id);

        if (reservaOptional.isEmpty()) return ResponseEntity.notFound().build();

        Reserva reserva = reservaOptional.get();

        return ResponseEntity.ok(reserva.JsonFormat());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable("id") Integer id, @RequestBody ReservaRequestDTO newData) {
        Optional<Reserva> reservaOptional = repository.findById(id);

        if (reservaOptional.isEmpty()) return  ResponseEntity.notFound().build();

        Reserva reserva = reservaOptional.get();
        reserva.setFuncionario(newData.funcionario());
        reserva.setHospede(newData.hospede());
        reserva.setQuarto(newData.quarto());
        reserva.setDataInicio(newData.dataInicio());
        reserva.setDataFim(newData.dataFim());
        reserva.setStatus(newData.status());

        repository.save(reserva);

        return ResponseEntity.ok(reservaOptional.get().JsonFormat());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable Integer id) {
        Optional<Reserva> reservaOptional = repository.findById(id);

        if (reservaOptional.isEmpty()) return ResponseEntity.notFound().build();

        repository.deleteById(id);

        return ResponseEntity.ok(reservaOptional.get().JsonFormat());
    }
}
