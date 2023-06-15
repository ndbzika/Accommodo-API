package com.example.Accommodo.services;

import com.example.Accommodo.dto.request.ReservaRequestDTO;
import com.example.Accommodo.entity.Funcionario;
import com.example.Accommodo.entity.Hospede;
import com.example.Accommodo.entity.Quarto;
import com.example.Accommodo.entity.Reserva;
import com.example.Accommodo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservarRepository;
    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private QuartoService quartoService;
    @Autowired
    private HospedeService hospedeService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva findById(Integer id) {
        Optional<Reserva> reserva = this.reservarRepository.findById(id);

        return reserva.orElseThrow(() -> new RuntimeException(
                "Reserva não encontrada! ID: " + id + ", Tipo: " + Reserva.class.getName()
        ));
    }

    public List<Reserva> findAll() {
        return this.reservarRepository.findAll();
    }

    @Transactional
    public Reserva create(ReservaRequestDTO data) throws ParseException {
        Date entryDate = sdf.parse(data.dataInicio());
        Date backDate = sdf.parse(data.dataFim());

        if (backDate.before(entryDate)) throw new RuntimeException("A data de entrada precisa ser após a de saída!");

        Integer idQuarto = data.quarto().getId();
        Integer idFuncionario = data.funcionario().getId();
        Integer idHospede = data.hospede().getId();

        Funcionario funcionario = funcionarioService.findById(idFuncionario);
        Quarto quarto = quartoService.findById(idQuarto);
        Hospede hospede = hospedeService.findById(idHospede);

        Reserva reserva = new Reserva(data);

        reserva.setHospede(hospede);
        reserva.setQuarto(quarto);
        reserva.setFuncionario(funcionario);

        return this.reservarRepository.save(reserva);
    }

    @Transactional
    public Reserva update(Integer id, ReservaRequestDTO data) throws ParseException {
        Reserva newData = findById(id);

        newData.setHospede(data.hospede());
        newData.setQuarto(data.quarto());
        newData.setFuncionario(data.funcionario());
        newData.setDataInicio(sdf.parse(data.dataInicio()));
        newData.setDataFim(sdf.parse(data.dataFim()));
        newData.setStatus(data.status());

        return this.reservarRepository.save(newData);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            this.reservarRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Reserva não existe!");
        }
    }
}
