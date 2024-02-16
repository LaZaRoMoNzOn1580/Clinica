package com.Hospital.api.Service;

import com.Hospital.api.DTO.HistoriaClinicaDTO;
import com.Hospital.api.Model.HistoriaClinica;
import com.Hospital.api.Model.Paciente;
import com.Hospital.api.Repository.HistoriaClinicaRepository;
import com.Hospital.api.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteService pacienteService;

    @Transactional
    public HistoriaClinica createHistoriaClinica(HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaClinica.setEdad(historiaClinicaDTO.getEdad());
        historiaClinica.setAlergias(historiaClinicaDTO.getAlergias());
        historiaClinica.setLargo(historiaClinicaDTO.getLargo());
        historiaClinica.setMasa(historiaClinicaDTO.getMasa());
        historiaClinica.setMalestares(historiaClinicaDTO.getMalestares());
        historiaClinica.setEnfermedadesGeneticas(historiaClinicaDTO.getEnfermedadesGeneticas());
        Paciente paciente = pacienteRepository.findById(historiaClinicaDTO.getPacienteId()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        pacienteService.updatePacienteWithHistoriaClinica(paciente.getId(), historiaClinica);
        return historiaClinicaRepository.save(historiaClinica);
    }

    public void deleteHistoria(Long historiaId) {
        historiaClinicaRepository.deleteById(historiaId);
    }

    public HistoriaClinica updateHistoriaClinica(Long historiaClinicaId, HistoriaClinicaDTO historiaClinicaDTO) {
        return  historiaClinicaRepository.findById(historiaClinicaId).map(historiaClinica -> {
            historiaClinica.setEdad(historiaClinicaDTO.getEdad());
            historiaClinica.setAlergias(historiaClinicaDTO.getAlergias());
            historiaClinica.setLargo(historiaClinicaDTO.getLargo());
            historiaClinica.setMasa(historiaClinicaDTO.getMasa());
            historiaClinica.setMalestares(historiaClinicaDTO.getMalestares());
            historiaClinica.setEnfermedadesGeneticas(historiaClinicaDTO.getEnfermedadesGeneticas());
            return  historiaClinicaRepository.save(historiaClinica);
        }).orElseThrow(() -> new RuntimeException("Historia Clinica no encontrada"));
    }
}
