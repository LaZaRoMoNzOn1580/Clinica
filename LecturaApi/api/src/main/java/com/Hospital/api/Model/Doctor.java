package com.Hospital.api.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor extends Users {

    @Column(name = "especialidad")
    private String speciality;

    @OneToMany(mappedBy = "doctor")
    @JsonManagedReference
    private List<Cita> dates;

    public Doctor(){}

    public Doctor(String name, String surname, String phoneNumber, String speciality, List<Cita> dates) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        this.speciality = speciality;
        this.dates = dates;
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
