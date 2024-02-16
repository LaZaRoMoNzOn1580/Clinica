package com.Hospital.api.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends Users {

    @Column(name = "especialidad")
    private String speciality;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonManagedReference("doctor-cita")
    private List<Cita> dates;

    public Doctor(){
        this.dates = new ArrayList<>();
    }

    public Doctor(String name, String surname, String phoneNumber, String speciality, List<Cita> dates) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        this.speciality = speciality;
        this.dates = (dates != null) ? dates : new ArrayList<>();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Cita> getDates() {
        return dates;
    }

    public void setDates(List<Cita> dates) {
        this.dates = dates;
    }
}
