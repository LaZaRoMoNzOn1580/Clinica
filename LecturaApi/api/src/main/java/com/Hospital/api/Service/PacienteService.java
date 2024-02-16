package com.Hospital.api.Service;

import com.Hospital.api.Model.Paciente;
import com.Hospital.api.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAllPacientes() { return pacienteRepository.findAll(); }

    public Optional<Paciente> findById(Long id) { return pacienteRepository.findById(id); }

    public List<Paciente> findByName(String name) { return pacienteRepository.findByName(name); }
}
