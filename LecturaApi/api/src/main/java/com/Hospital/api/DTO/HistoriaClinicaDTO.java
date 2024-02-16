package com.Hospital.api.DTO;

public class HistoriaClinicaDTO {

    private Long id;
    private Integer edad;
    private Double masa;
    private Double largo;
    private String enfermedadesGeneticas;
    private String malestares;
    private String pacienteName;

    HistoriaClinicaDTO() {}

    public HistoriaClinicaDTO(Long id, Integer edad, Double masa, Double largo, String enfermedadesGeneticas, String malestares, String pacienteName) {
        this.id = id;
        this.edad = edad;
        this.masa = masa;
        this.largo = largo;
        this.enfermedadesGeneticas = enfermedadesGeneticas;
        this.malestares = malestares;
        this.pacienteName = pacienteName;

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

    public String getMalestares() {
        return malestares;
    }

    public void setMalestares(String malestares) {
        this.malestares = malestares;
    }

    public String getPacienteName() {
        return pacienteName;
    }

    public void setPacienteName(String pacienteName) {
        this.pacienteName = pacienteName;
    }

    @Override
    public String toString() {
        return "HistoriaClinicaDTO{" +
                "id=" + id +
                ", edad=" + edad +
                ", masa=" + masa +
                ", largo=" + largo +
                ", enfermedadesGeneticas='" + enfermedadesGeneticas + '\'' +
                ", malestares='" + malestares + '\'' +
                ", pacienteName='" + pacienteName + '\'' +
                '}';
    }
}
