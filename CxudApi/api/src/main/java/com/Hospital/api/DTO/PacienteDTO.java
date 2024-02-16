package com.Hospital.api.DTO;

import com.Hospital.api.Model.HistoriaClinica;

import java.util.List;

public class PacienteDTO extends UserDto {

    private List<CitaDTO> dates;
    private Long historiaClinicaId;

    public PacienteDTO() {}

    public PacienteDTO(String name, String surname, String phoneNumber,List<CitaDTO> dates, Long historiaClinicaId ) {
        setName(name);
        setSurname(surname);
        setPhoneNumber(phoneNumber);
        this.dates = dates;
        this.historiaClinicaId = historiaClinicaId;
    }

    public List<CitaDTO> getDates() {
        return dates;
    }

    public void setDates(List<CitaDTO> dates) {
        this.dates = dates;
    }

    public Long getHistoriaClinicaId() {
        return historiaClinicaId;
    }

    public void setHistoriaClinicaId(Long historiaClinicaId) {
        this.historiaClinicaId = historiaClinicaId;
    }
}
