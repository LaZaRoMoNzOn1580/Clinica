package com.Hospital.api.Controller;

import com.Hospital.api.DTO.PacienteDTO;
import com.Hospital.api.Model.Paciente;
import com.Hospital.api.Service.PacienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> getAllPacientes() {
        List<Paciente> pacientes = pacienteService.findAllPacientes();
        List<PacienteDTO> pacienteDtos = pacientes.stream()
                .map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(pacienteDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> getPacienteById(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.findById(id);
        if (paciente != null) {
            PacienteDTO pacienteDto = modelMapper.map(paciente, PacienteDTO.class);
            return ResponseEntity.ok(pacienteDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<PacienteDTO>> getPacientesByName(@RequestParam String name) {
        List<Paciente> pacientes = pacienteService.findByName(name);
        List<PacienteDTO> pacienteDtos = pacientes.stream()
                .map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(pacienteDtos);
    }

}
