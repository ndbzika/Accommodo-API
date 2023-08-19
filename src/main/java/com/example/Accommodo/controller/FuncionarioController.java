package com.example.Accommodo.controller;

import com.example.Accommodo.dto.request.FuncionarioRequestDTO;
import com.example.Accommodo.dto.response.FuncionarioResponseDTO;
import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.repository.FuncionarioRepository;
import com.example.Accommodo.services.FuncionarioService;
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
@RequestMapping(value = "funcionarios", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    //CREATE
    @PostMapping
    public ResponseEntity<Funcionario> store(@RequestBody FuncionarioRequestDTO data) {
        this.funcionarioService.create(data);
        return ResponseEntity.ok().build();
    }

    //READ
    @GetMapping
    public ResponseEntity<List<Funcionario>> index() {
        List<Funcionario> funcionarioList = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarioList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> show(@PathVariable("id") Integer id) {
        Funcionario funcionario = this.funcionarioService.findById(id);
        return ResponseEntity.ok(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable("id") Integer id, @RequestBody FuncionarioRequestDTO newData) {
        this.funcionarioService.update(id, newData);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable Integer id) {
        this.funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
