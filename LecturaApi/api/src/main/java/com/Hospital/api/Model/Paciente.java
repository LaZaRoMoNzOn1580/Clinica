package com.Hospital.api.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paciente")
public class Paciente extends Users{

    @OneToMany(mappedBy = "paciente")
    @JsonManagedReference
    private List<Cita> dates;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_historia_clinica", referencedColumnName = "id")
    private HistoriaClinica historiaClinica;

    public Paciente() {}

    public Paciente(String name, String surname, String phoneNumber, List<Cita> dates, HistoriaClinica historiaClinica) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        this.dates = dates;
        this.historiaClinica = historiaClinica;
    }

    public List<Cita> getDates() {
        return dates;
    }

    public void setDates(List<Cita> dates) {
        this.dates = dates;
    }

    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }
}
