package com.example.Accommodo.controller;

import com.example.Accommodo.dto.request.QuartoRequestDTO;
import com.example.Accommodo.dto.request.QuartoRequestDTO;
import com.example.Accommodo.dto.response.QuartoResponseDTO;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/quartos", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuartoController {

    @Autowired
    private QuartoRepository repository;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public List<QuartoResponseDTO> index() {
        List<QuartoResponseDTO> quartoList = repository.findAll().stream().map(QuartoResponseDTO::new).toList();
        return quartoList;
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> show(@PathVariable("id") Integer id) {
        Optional<Quarto> quartoOptional = repository.findById(id);
        if (quartoOptional.isEmpty()) return ResponseEntity.notFound().build();

        Quarto quarto = quartoOptional.get();

        return ResponseEntity.ok(quarto.JsonFormat());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Map<String, Object>> store(@RequestBody QuartoRequestDTO data) {
        Quarto quarto = new Quarto(data);
        repository.save(quarto);

        return ResponseEntity.ok(quarto.JsonFormat());
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable("id") Integer id, @RequestBody QuartoRequestDTO newData) {
        Optional<Quarto> quartoOptional = repository.findById(id);

        if (quartoOptional.isEmpty()) return ResponseEntity.notFound().build();

        Quarto quarto = quartoOptional.get();
        quarto.setNumero(newData.numero());
        quarto.setTipo(newData.tipo());
        quarto.setStatus(newData.status());
        quarto.setPreco(newData.preco());

        repository.save(quarto);

        return ResponseEntity.ok(quarto.JsonFormat());
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable Integer id) {
        Optional<Quarto> quartoOptional = repository.findById(id);

        if (quartoOptional.isEmpty()) return ResponseEntity.notFound().build();

        repository.deleteById(id);

        return ResponseEntity.ok(quartoOptional.get().JsonFormat());
    }
}
