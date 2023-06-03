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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class ReservaController {

    @Autowired
    private ReservaRepository repository;

    private  FuncionarioRepository funcionarioRepository;
    private QuartoRepository quartoRepository;
    private HospedeRepository hospedeRepository;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @PostMapping
    public ResponseEntity<Map<String, Object>> store(@RequestBody ReservaRequestDTO data) throws ParseException {
        Date entryDate = sdf.parse(data.dataInicio());
        Date backDate = sdf.parse(data.dataFim());

        Integer idQuarto = data.quarto().getId();
        Integer idFuncionario = data.funcionario().getId();
        Integer idHospede = data.hospede().getId();

        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                .orElseThrow(() -> new ResourceAccessException("Funcionario não encontrado"));

        Quarto quarto = quartoRepository.findById(idQuarto)
                .orElseThrow(() -> new ResourceAccessException("Quarto não encontrado"));

        Hospede hospede = hospedeRepository.findById(idHospede)
                .orElseThrow(() -> new ResourceAccessException("Hospede não encontrado"));

        if (backDate.before(entryDate)) return ResponseEntity.badRequest().build();

        Reserva reserva = new Reserva(data);

        reserva.setFuncionario(funcionario);
        reserva.setQuarto(quarto);
        reserva.setHospede(hospede);

        repository.save(reserva);

        return ResponseEntity.ok(reserva.JsonFormat());
    }

    @GetMapping
    public ResponseEntity index() {
        List<ReservaResponseDTO> reservaList = repository.findAll().stream().map(ReservaResponseDTO::new).toList();
        return ResponseEntity.ok(reservaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> show(@PathVariable("id") Integer id) {
        Optional<Reserva> reservaOptional = repository.findById(id);

        if (reservaOptional.isEmpty()) return ResponseEntity.notFound().build();

        Reserva reserva = reservaOptional.get();

        return ResponseEntity.ok(reserva.JsonFormat());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable("id") Integer id, @RequestBody ReservaRequestDTO newData) throws ParseException {
        Optional<Reserva> reservaOptional = repository.findById(id);

        if (reservaOptional.isEmpty()) return  ResponseEntity.notFound().build();

        Reserva reserva = reservaOptional.get();
        reserva.setHospede(newData.hospede());
        reserva.setQuarto(newData.quarto());
        reserva.setFuncionario(newData.funcionario());
        reserva.setDataInicio(sdf.parse(newData.dataInicio()));
        reserva.setDataFim(sdf.parse(newData.dataFim()));
        reserva.setStatus(newData.status());

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
