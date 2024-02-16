package com.Hospital.api.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
public class CitaDTO {
        private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        private Date fecha;
        private String doctorName;
        private String pacienteName;

        public CitaDTO () {}

        public CitaDTO(Long id, Date fecha, String doctorName, String pacienteName) {
            this.fecha = fecha;
            this.doctorName = doctorName;
            this.pacienteName = pacienteName;
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPacienteName() {
        return pacienteName;
    }

    public void setPacienteName(String pacienteName) {
        this.pacienteName = pacienteName;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(fecha);
        return "CitaDTO{" +
                "id=" + id +
                ", fecha=" + formattedDate +
                ", doctorName='" + doctorName + '\'' +
                ", pacienteName='" + pacienteName + '\'' +
                '}';
    }
}

