package com.example.Accommodo.controller;

import com.example.Accommodo.dto.request.HospedeRequestDTO;
import com.example.Accommodo.dto.response.HospedeResponseDTO;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.repository.HospedeRepository;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hospedes", produces = MediaType.APPLICATION_JSON_VALUE)
public class HospedeController {

    @Autowired
    private HospedeRepository repository;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Hospede> store(@RequestBody HospedeRequestDTO data) {
        Hospede hospede = new Hospede(data);
        repository.save(hospede);

        return ResponseEntity.ok(hospede);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public List<HospedeResponseDTO> index() {
        List<HospedeResponseDTO> hospedesList = repository.findAll().stream().map(HospedeResponseDTO::new).toList();
        return hospedesList;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> show(@PathVariable("id") Integer id) {
        Optional<Hospede> hospedeOptional = repository.findById(id);
        if (hospedeOptional.isEmpty()) return ResponseEntity.notFound().build();

        Hospede hospede = hospedeOptional.get();

        return ResponseEntity.ok(hospede.JsonFormat());
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable("id") Integer id, @RequestBody HospedeRequestDTO newHospedeData) {
        Optional<Hospede> hospedeOptional = repository.findById(id);

        if (hospedeOptional.isEmpty()) return ResponseEntity.notFound().build();

        Hospede hospede = hospedeOptional.get();
        hospede.setNome(newHospedeData.nome());
        hospede.setEmail(newHospedeData.email());
        hospede.setTelefone(newHospedeData.telefone());

        repository.save(hospede);

        return ResponseEntity.ok(hospede.JsonFormat());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Integer id) {
        Optional<Hospede> hospedeOptional = repository.findById(id);

        if (hospedeOptional.isEmpty()) return ResponseEntity.notFound().build();

        repository.deleteById(id);

        return ResponseEntity.ok(hospedeOptional.get().JsonFormat());
    }
}
