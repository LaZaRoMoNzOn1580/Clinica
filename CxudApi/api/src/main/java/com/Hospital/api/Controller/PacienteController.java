package com.Hospital.api.Controller;

import com.Hospital.api.Model.Doctor;
import com.Hospital.api.Model.Paciente;
import com.Hospital.api.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente) {
        Paciente createdPaciente = pacienteService.createPaciente(paciente);
        return new ResponseEntity<>(createdPaciente, HttpStatus.CREATED);
    }

    @DeleteMapping("/{pacienteId}")
    public ResponseEntity<?> deletePaciente(@PathVariable Long pacienteId) {
        try{
            pacienteService.deletePaciente(pacienteId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{pacienteId}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Long pacienteId, @RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.updatePaciente(pacienteId, paciente));
    }
}
