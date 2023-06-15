package com.example.Accommodo.controller;

import com.example.Accommodo.dto.request.ReservaRequestDTO;
import com.example.Accommodo.dto.response.ReservaResponseDTO;
import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.entity.Reserva;
import com.example.Accommodo.repository.FuncionarioRepository;
import com.example.Accommodo.repository.HospedeRepository;
import com.example.Accommodo.repository.QuartoRepository;
import com.example.Accommodo.repository.ReservaRepository;
import com.example.Accommodo.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "reservas", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> store(@RequestBody ReservaRequestDTO data) throws ParseException {
        this.reservaService.create(data);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> index() {
        List<Reserva> reservaList = reservaService.findAll();
        return ResponseEntity.ok(reservaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> show(@PathVariable("id") Integer id) {
        Reserva reserva = this.reservaService.findById(id);

        return ResponseEntity.ok(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> update(@PathVariable("id") Integer id, @RequestBody ReservaRequestDTO newData) throws ParseException {
        this.reservaService.update(id, newData);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reserva> delete(@PathVariable Integer id) {
        this.reservaService.delete(id);

        return ResponseEntity.ok().build();
    }
}
