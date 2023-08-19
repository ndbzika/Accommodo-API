package com.example.Accommodo.controller;

import com.example.Accommodo.dto.request.HospedeRequestDTO;
import com.example.Accommodo.dto.response.HospedeResponseDTO;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.repository.HospedeRepository;
import com.example.Accommodo.services.HospedeService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hospedes", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HospedeController {

    @Autowired
    private HospedeService hospedeService;

    @PostMapping
    public ResponseEntity<Hospede> store(@RequestBody HospedeRequestDTO data) {
        this.hospedeService.create(data);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<HospedeResponseDTO> index() {
        List<HospedeResponseDTO> hospedesList = hospedeService.findAll().stream().map(HospedeResponseDTO::new).toList();
        return hospedesList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospede> show(@PathVariable("id") Integer id) {
        Hospede hospede = this.hospedeService.findById(id);
        return ResponseEntity.ok(hospede);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospede> update(@PathVariable("id") Integer id, @RequestBody HospedeRequestDTO newHospedeData) {
        this.hospedeService.update(id,newHospedeData);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hospede> delete(@PathVariable("id") Integer id) {
        this.hospedeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
