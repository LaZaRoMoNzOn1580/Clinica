package com.Hospital.api.Service;

import com.Hospital.api.DTO.HistoriaClinicaDTO;
import com.Hospital.api.Model.Cita;
import com.Hospital.api.Model.Doctor;
import com.Hospital.api.Model.HistoriaClinica;
import com.Hospital.api.Model.Paciente;
import com.Hospital.api.Repository.CitaRepository;
import com.Hospital.api.Repository.HistoriaClinicaRepository;
import com.Hospital.api.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    HistoriaClinicaRepository historiaClinicaRepository;
    @Autowired
    CitaRepository citaRepository;

    public Paciente createPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> findById(Long id) { return pacienteRepository.findById(id); }

    public List<Paciente> findByName(String name) { return pacienteRepository.findByName(name); }

    public void updatePacienteWithHistoriaClinica(Long pacienteId, HistoriaClinica historiaClinica) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no econtrado"));
        paciente.setHistoriaClinica(historiaClinica);
        pacienteRepository.save(paciente);
    }

    @Transactional
    public void deletePaciente(Long pacienteId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        historiaClinicaRepository.deleteById(paciente.getHistoriaClinica().getId());
        for (Cita cita : paciente.getDates()) {
            citaRepository.deleteById(cita.getId());
        }

        pacienteRepository.delete(paciente);
    }

    public Paciente updatePaciente(Long pacienteId, Paciente updatedPaciente) {
        return pacienteRepository.findById(pacienteId).map(paciente -> {
            paciente.setName(updatedPaciente.getName());
            paciente.setSurname(updatedPaciente.getSurname());
            paciente.setPhoneNumber(updatedPaciente.getPhoneNumber());

            if (updatedPaciente.getHistoriaClinica() != null && updatedPaciente.getHistoriaClinica() != null) {
                Long historiaClinicaId = updatedPaciente.getHistoriaClinica().getId();
                HistoriaClinica historiaClinica = historiaClinicaRepository.findById(historiaClinicaId)
                        .orElseThrow(() -> new RuntimeException("Historia Clinica no encontrada"));
                paciente.setHistoriaClinica(historiaClinica);
            }
            return pacienteRepository.save(paciente);
        }).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
    }
}
