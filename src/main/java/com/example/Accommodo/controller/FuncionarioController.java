package com.example.Accommodo.controller;

import com.example.Accommodo.dto.request.FuncionarioRequestDTO;
import com.example.Accommodo.dto.response.FuncionarioResponseDTO;
import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "funcionarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    //CREATE
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Map<String, Object>> store(@RequestBody FuncionarioRequestDTO data) {
        Funcionario funcionario = new Funcionario(data);
        repository.save(funcionario);

        return ResponseEntity.ok(funcionario.JsonFormat());
    }

    //READ
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity index() {
        List<FuncionarioResponseDTO> funcionarioList = repository.findAll().stream().map(FuncionarioResponseDTO::new).toList();
        return ResponseEntity.ok(funcionarioList);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/{id}")
    public ResponseEntity<Map<String,Object>> show(@PathVariable("id") Integer id) {
        Optional<Funcionario> funcionarioOptional = repository.findById(id);
        if (funcionarioOptional.isEmpty()) return ResponseEntity.notFound().build();

        Funcionario funcionario = funcionarioOptional.get();

        return ResponseEntity.ok(funcionario.JsonFormat());
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(@PathVariable("id") Integer id, @RequestBody FuncionarioRequestDTO newData) {
        Optional<Funcionario> funcionarioOptional = repository.findById(id);

        if (funcionarioOptional.isEmpty()) return ResponseEntity.notFound().build();

        Funcionario funcionario = funcionarioOptional.get();
        funcionario.setNome(newData.nome());
        funcionario.setCargo(newData.cargo());
        funcionario.setSalario(newData.salario());
        funcionario.setEmail(newData.email());
        funcionario.setTelefone(newData.telefone());

        repository.save(funcionario);

        return ResponseEntity.ok(funcionario.JsonFormat());
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> delete(@PathVariable Integer id) {
        Optional<Funcionario> funcionarioOptional = repository.findById(id);

        if (funcionarioOptional.isEmpty()) return ResponseEntity.notFound().build();

        repository.deleteById(id);

        return ResponseEntity.ok(funcionarioOptional.get().JsonFormat());
    }
}
