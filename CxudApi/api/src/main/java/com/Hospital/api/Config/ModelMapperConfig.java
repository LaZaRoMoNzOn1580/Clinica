package com.Hospital.api.Config;

import com.Hospital.api.DTO.CitaDTO;
import com.Hospital.api.Model.Cita;
import com.Hospital.api.Repository.DoctorRepository;
import com.Hospital.api.Repository.PacienteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);

        TypeMap<CitaDTO, Cita> typeMap = mapper.createTypeMap(CitaDTO.class, Cita.class);

        typeMap.addMappings(m -> {
            m.map(CitaDTO::getFecha, Cita::setFecha);
        });

        typeMap.setPostConverter(context -> {
            CitaDTO source = context.getSource();
            Cita destination = context.getDestination();

            if (source.getDoctorId() != null) {
                destination.setDoctor(doctorRepository.findById(source.getDoctorId()).orElse(null));
            }
            if (source.getPacienteId() != null) {
                destination.setPaciente(pacienteRepository.findById(source.getPacienteId()).orElse(null));
            }

            return destination;
        });

        return mapper;
    }
}
