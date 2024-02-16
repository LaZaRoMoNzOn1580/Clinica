package com.Hospital.api.Controller;

import com.Hospital.api.DTO.CitaDTO;
import com.Hospital.api.Model.Cita;
import com.Hospital.api.Service.CitaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CitaDTO>> getAllCitas() {
        List<Cita> citas = citaService.findAllCitas();
        List<CitaDTO> citaDtos = citas.stream()
                .map(cita -> modelMapper.map(cita, CitaDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(citaDtos);
    }
}
