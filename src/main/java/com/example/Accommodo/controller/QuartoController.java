package com.example.Accommodo.controller;

import com.example.Accommodo.dto.request.QuartoRequestDTO;
import com.example.Accommodo.dto.request.QuartoRequestDTO;
import com.example.Accommodo.dto.response.QuartoResponseDTO;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.repository.QuartoRepository;
import com.example.Accommodo.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/quartos", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@CrossOrigin(origins = "https://accommodo-frontend-production.up.railway.app", allowedHeaders = "*")
public class QuartoController {

    @Autowired
    private QuartoService quartoService;

    @GetMapping
    public List<QuartoResponseDTO> index() {
        List<QuartoResponseDTO> quartoList = this.quartoService.findAll().stream().map(QuartoResponseDTO::new).toList();
        return quartoList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quarto> show(@PathVariable("id") Integer id) {
        Quarto quarto = this.quartoService.findById(id);
        return ResponseEntity.ok().body(quarto);
    }

    @PostMapping
    public ResponseEntity<Void> store(@RequestBody QuartoRequestDTO data) {
        this.quartoService.create(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody QuartoRequestDTO newData) {
        this.quartoService.update(id, newData);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable Integer id) {
        this.quartoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
