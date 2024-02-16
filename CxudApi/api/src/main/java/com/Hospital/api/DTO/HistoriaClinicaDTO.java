package com.Hospital.api.DTO;

public class HistoriaClinicaDTO {

    private Integer edad;
    private Double masa;
    private Double largo;
    private String enfermedadesGeneticas;
    private String malestares;
    private Long pacienteId;
    private String alergias;

    HistoriaClinicaDTO() {}

    public HistoriaClinicaDTO(String alergias,Integer edad, Double masa, Double largo, String enfermedadesGeneticas, String malestares, Long pacienteId) {
        this.edad = edad;
        this.masa = masa;
        this.largo = largo;
        this.enfermedadesGeneticas = enfermedadesGeneticas;
        this.malestares = malestares;
        this.pacienteId = pacienteId;
        this.alergias = alergias;

    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
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

    public String getMalestares() {
        return malestares;
    }

    public void setMalestares(String malestares) {
        this.malestares = malestares;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public String toString() {
        return "HistoriaClinicaDTO{" +
                "edad=" + edad +
                ", masa=" + masa +
                ", largo=" + largo +
                ", enfermedadesGeneticas='" + enfermedadesGeneticas + '\'' +
                ", malestares='" + malestares + '\'' +
                ", pacienteName='" + pacienteId + '\'' +
                ", alergias='" + alergias + '\'' +
                '}';
    }
}
