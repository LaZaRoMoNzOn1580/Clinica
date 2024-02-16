package com.Hospital.api.Controller;


import com.Hospital.api.DTO.HistoriaClinicaDTO;
import com.Hospital.api.Model.HistoriaClinica;
import com.Hospital.api.Service.HistoriaClinicaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/historias")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<HistoriaClinicaDTO>> getAllHistorias() {
        List<HistoriaClinica> historiaClinicas = historiaClinicaService.findAllHistorias();
        List<HistoriaClinicaDTO> historiaClinicaDTOS = historiaClinicas.stream()
                .map(historiaClinica -> modelMapper.map(historiaClinica, HistoriaClinicaDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(historiaClinicaDTOS);
    }
}
