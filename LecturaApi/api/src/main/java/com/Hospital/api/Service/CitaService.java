package com.Hospital.api.Service;

import com.Hospital.api.Model.Cita;
import com.Hospital.api.Repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> findAllCitas() { return citaRepository.findAll(); }
}
