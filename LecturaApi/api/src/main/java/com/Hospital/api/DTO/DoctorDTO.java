package com.Hospital.api.DTO;

import java.util.List;

public class DoctorDTO extends UserDto{

    private String speciality;

    private List<CitaDTO> dates;

    public DoctorDTO() {}

    public DoctorDTO(String name, String surname, String phoneNumber, String speciality, List<CitaDTO> dates) {
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

    public List<CitaDTO> getDates() {
        return dates;
    }

    public void setDates(List<CitaDTO> dates) {
        this.dates = dates;
    }
}
