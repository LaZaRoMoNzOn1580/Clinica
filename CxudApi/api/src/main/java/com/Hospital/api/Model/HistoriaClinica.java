package com.Hospital.api.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "historiaclinica")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer edad;

    @Column
    private Double masa;

    @Column
    private Double largo;

    @Column(name = "enfermedades_geneticas")
    private String enfermedadesGeneticas;

    @Column
    private String alergias;

    @Column
    private String malestares;

    @OneToOne(mappedBy = "historiaClinica")
    @JsonManagedReference("historiaClinica-paciente")
    private Paciente paciente;

    public HistoriaClinica() {}

    public HistoriaClinica(Integer edad, Double masa, Double largo, String enfermedadesGeneticas, String alergias, String malestares, Paciente paciente) {
        this.edad = edad;
        this.masa = masa;
        this.largo = largo;
        this.enfermedadesGeneticas = enfermedadesGeneticas;
        this.alergias = alergias;
        this.malestares = malestares;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getMasa() {
        return masa;
    }

    public void setMasa(Double masa) {
        this.masa = masa;
    }

    public Double getLargo() {
        return largo;
    }

    public void setLargo(Double largo) {
        this.largo = largo;
    }

    public String getEnfermedadesGeneticas() {
        return enfermedadesGeneticas;
    }

    public void setEnfermedadesGeneticas(String enfermedadesGeneticas) {
        this.enfermedadesGeneticas = enfermedadesGeneticas;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getMalestares() {
        return malestares;
    }

    public void setMalestares(String malestares) {
        this.malestares = malestares;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
