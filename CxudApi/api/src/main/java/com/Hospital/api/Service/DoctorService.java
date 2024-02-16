package com.Hospital.api.Service;

import com.Hospital.api.Model.Cita;
import com.Hospital.api.Model.Doctor;
import com.Hospital.api.Repository.CitaRepository;
import com.Hospital.api.Repository.DoctorRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private CitaRepository citaRepository;

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> findDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> findDoctorsByName(String name) {
        return doctorRepository.findByName(name);
    }

    @Transactional
    public void deleteDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        for (Cita cita : doctor.getDates()) {
            cita.setDoctor(null);
            citaRepository.save(cita);
        }
        doctorRepository.delete(doctor);
    }

    public Doctor updateDoctor(Long doctorId, Doctor updatedDoctor) {
        return doctorRepository.findById(doctorId).map(doctor -> {
            doctor.setName(updatedDoctor.getName());
            doctor.setSurname(updatedDoctor.getSurname());
            doctor.setPhoneNumber(updatedDoctor.getPhoneNumber());
            doctor.setSpeciality(updatedDoctor.getSpeciality());
            return doctorRepository.save(doctor);
        }).orElseThrow(() -> new RuntimeException("Doctor no encontrado"));
    }


}
