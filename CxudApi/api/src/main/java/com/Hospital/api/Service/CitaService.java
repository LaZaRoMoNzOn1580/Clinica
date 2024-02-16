package com.Hospital.api.Service;

import com.Hospital.api.DTO.CitaDTO;
import com.Hospital.api.Model.Cita;
import com.Hospital.api.Model.Doctor;
import com.Hospital.api.Model.Paciente;
import com.Hospital.api.Repository.CitaRepository;
import com.Hospital.api.Repository.DoctorRepository;
import com.Hospital.api.Repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Cita createDate(CitaDTO citaDTO) {
        Cita cita = modelMapper.map(citaDTO, Cita.class);

        if(cita.getDoctor() == null || cita.getPaciente() == null) {
            throw new IllegalStateException("Doctor o paciente no encontrado");
        }

        return citaRepository.save(cita);
    }

    public void deleteCita(Long citaId) {
        citaRepository.deleteById(citaId);
    }

    public Cita updateCita(Long citaId, CitaDTO citaDTO) {

        return citaRepository.findById(citaId).map(cita -> {

            cita.setFecha(citaDTO.getFecha());

            Doctor doctor = doctorRepository.findById(citaDTO.getDoctorId())
                    .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

            Paciente paciente = pacienteRepository.findById(citaDTO.getPacienteId())
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

            cita.setDoctor(doctor);
            cita.setPaciente(paciente);

            Cita updatedCita = citaRepository.save(cita);

            return updatedCita;
        }).orElseThrow(() -> new RuntimeException("Cita no encontrada con id: " + citaId));
    }

}
