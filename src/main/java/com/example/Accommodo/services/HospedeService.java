package com.example.Accommodo.services;

import com.example.Accommodo.dto.request.HospedeRequestDTO;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {
    @Autowired
    private HospedeRepository repository;

    public Hospede findById(Integer id) {
        Optional<Hospede> hospede = this.repository.findById(id);
        return hospede.orElseThrow(() -> new RuntimeException(
                "Hospede não encontrado! ID: " + id + ", Tipo: " + Hospede.class.getName()
        ));
    }

    public List<Hospede> findAll() {
        List<Hospede> hospedes = this.repository.findAll();
        return hospedes;
    }

    @Transactional
    public Hospede create(HospedeRequestDTO data) {
        Hospede hospede = new Hospede(data);

        return repository.save(hospede);
    }

    @Transactional
    public Hospede update(Integer id, HospedeRequestDTO data) {
        Hospede newData = findById(id);

        newData.setNome(data.nome());
        newData.setEmail(data.email());
        newData.setTelefone(data.telefone());

        return this.repository.save(newData);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Usuário não existe!");
        }
    }
}
