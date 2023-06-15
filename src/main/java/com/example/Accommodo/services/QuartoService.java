package com.example.Accommodo.services;

import com.example.Accommodo.dto.request.QuartoRequestDTO;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.repository.QuartoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuartoService {

    @Autowired
    private QuartoRepository repository;

    public Quarto findById(Integer id) {
        Optional<Quarto> quarto = this.repository.findById(id);

        return quarto.orElseThrow(() -> new RuntimeException(
                "Quarto não encontrado! ID: " + id + ", Tipo: " + Quarto.class.getName()
        ));
    }

    public List<Quarto> findAll() {
        List<Quarto> quartos = this.repository.findAll();
        return quartos;
    }

    @Transactional
    public Quarto create(QuartoRequestDTO data) {
        Quarto quarto = new Quarto(data);

        return repository.save(quarto);
    }

    @Transactional
    public Quarto update(Integer id, QuartoRequestDTO data) {
        Quarto newData = findById(id);
        newData.setNumero(data.numero());
        newData.setTipo(data.tipo());
        newData.setStatus(data.status());
        newData.setPreco(data.preco());

        return this.repository.save(newData);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Quarto não existe!");
        }
    }
}
