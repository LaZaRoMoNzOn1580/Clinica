package com.Hospital.api.Controller;

import com.Hospital.api.DTO.HistoriaClinicaDTO;
import com.Hospital.api.Model.HistoriaClinica;
import com.Hospital.api.Service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/historias")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @PostMapping
    public ResponseEntity<HistoriaClinica> createHistoriaClinica(@RequestBody HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica historiaClinica = historiaClinicaService.createHistoriaClinica(historiaClinicaDTO);
        return new ResponseEntity<>(historiaClinica, HttpStatus.CREATED);
    }

    @DeleteMapping("/{historiaId}")
    public ResponseEntity<?> deleteHistoria(@PathVariable Long historiaId) {
        try {
            historiaClinicaService.deleteHistoria(historiaId);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{historiaId}")
    public ResponseEntity<HistoriaClinica> updateHistoriaClinica(@PathVariable Long historiaId, @RequestBody HistoriaClinicaDTO historiaClinicaDTO) {
        HistoriaClinica updatedHistoriaClinica = historiaClinicaService.updateHistoriaClinica(historiaId,historiaClinicaDTO);
        return ResponseEntity.ok(updatedHistoriaClinica);
    }
}
