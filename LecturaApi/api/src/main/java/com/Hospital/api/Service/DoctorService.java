package com.Hospital.api.Service;

import com.Hospital.api.DTO.CitaDTO;
import com.Hospital.api.DTO.DoctorDTO;
import com.Hospital.api.Model.Cita;
import com.Hospital.api.Model.Doctor;
import com.Hospital.api.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> findDoctorsByName(String name) {
        return doctorRepository.findByName(name);
    }
}
