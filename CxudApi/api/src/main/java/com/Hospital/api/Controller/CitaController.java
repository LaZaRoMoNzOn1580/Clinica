package com.Hospital.api.Controller;

import com.Hospital.api.DTO.CitaDTO;
import com.Hospital.api.Model.Cita;
import com.Hospital.api.DTO.CitaResponseDTO;
import com.Hospital.api.Service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<CitaResponseDTO> createDate(@RequestBody CitaDTO citaDTO){
        Cita createDate = citaService.createDate(citaDTO);
        CitaResponseDTO responseDTO = new CitaResponseDTO();
        responseDTO.setId(createDate.getId());
        responseDTO.setFecha(createDate.getFecha());
        responseDTO.setDoctorName(createDate.getDoctor().getName());
        responseDTO.setPacienteName(createDate.getPaciente().getName());
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{citaId}")
    public ResponseEntity<?> deleteCita(@PathVariable Long citaId) {
        citaService.deleteCita(citaId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{citaId}")
    public ResponseEntity<CitaResponseDTO> updateCita(@PathVariable Long citaId, @RequestBody CitaDTO citaDTO) {
        if (citaId == null) {
            return ResponseEntity.badRequest().build();
        }


        Cita updatedCita = citaService.updateCita(citaId, citaDTO);
        if (updatedCita == null) {
            return ResponseEntity.notFound().build();
        }
        CitaResponseDTO responseDTO = new CitaResponseDTO();
        responseDTO.setId(updatedCita.getId());
        responseDTO.setFecha(updatedCita.getFecha());
        responseDTO.setDoctorName(updatedCita.getDoctor().getName());
        responseDTO.setPacienteName(updatedCita.getPaciente().getName());
        return ResponseEntity.ok(responseDTO);
    }
}
