package com.Hospital.api.Controller;

import com.Hospital.api.DTO.DoctorDTO;
import com.Hospital.api.Model.Doctor;
import com.Hospital.api.Service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<Doctor> doctors = doctorService.findAllDoctors();
        List<DoctorDTO> doctorDTOS = doctors.stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(doctorDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorService.findDoctorById(id);
        if(doctor != null) {
            DoctorDTO doctorDTO = modelMapper.map(doctor, DoctorDTO.class);
            return ResponseEntity.ok(doctorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Doctor>> getDoctorsByName(@RequestParam String name) {
        List<Doctor> doctors = doctorService.findDoctorsByName(name);
        List<DoctorDTO> doctorDTOS = doctors.stream()
                .map(doctor -> modelMapper.map(doctor,DoctorDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(doctors);
    }

}
