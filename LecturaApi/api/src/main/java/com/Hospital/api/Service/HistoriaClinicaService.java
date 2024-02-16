package com.Hospital.api.Service;

import com.Hospital.api.Model.HistoriaClinica;
import com.Hospital.api.Repository.HistoriaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;

    public List<HistoriaClinica> findAllHistorias() { return historiaClinicaRepository.findAll(); }
}
