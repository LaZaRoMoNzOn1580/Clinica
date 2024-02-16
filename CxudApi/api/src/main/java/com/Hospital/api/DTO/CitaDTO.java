package com.Hospital.api.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
public class CitaDTO {
        private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        private Date fecha;

    private Long doctorId;
    private Long pacienteId;

    public CitaDTO(Date fecha, Long doctorId, Long pacienteId) {
        this.fecha = fecha;
        this.doctorId = doctorId;
        this.pacienteId = pacienteId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public String toString() {
        return "CitaDTO{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", doctorId=" + doctorId +
                ", pacienteId=" + pacienteId +
                '}';
    }
}

