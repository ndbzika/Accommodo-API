package com.example.Accommodo.services;

import com.example.Accommodo.dto.request.FuncionarioRequestDTO;
import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository repository;

    public Funcionario findById(Integer id) {
        Optional<Funcionario> funcionario= this.repository.findById(id);

        return funcionario.orElseThrow(() -> new RuntimeException(
                "Funcionario não encontrado! ID: " + id + ", Tipo: " + Funcionario.class.getName()
        ));
    }

    public List<Funcionario> findAll() {
        List<Funcionario> funcionarios = this.repository.findAll();
        return funcionarios;
    }

    @Transactional
    public Funcionario create(FuncionarioRequestDTO data) {
        Funcionario funcionario = new Funcionario(data);

        return repository.save(funcionario);
    }

    @Transactional
    public Funcionario update(Integer id, FuncionarioRequestDTO data) {
        Funcionario newData = findById(id);

        newData.setNome(data.nome());
        newData.setCargo(data.cargo());
        newData.setSalario(data.salario());
        newData.setEmail(data.email());
        newData.setTelefone(data.telefone());

        return repository.save(newData);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Funcionario não encontrado!");
        }
    }
}
