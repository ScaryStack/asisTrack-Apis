package com.duocdevs.asistrack.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "ASISTENCIA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAttendance;

    private String typeAttendance;

    @Temporal(TemporalType.TIME)
    @Column(name = "fecha", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDate date;

    @Temporal(TemporalType.TIME)
    @Column(name = "hora_registro", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalTime hour;

    private String location;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "USER_userId")
    private User user;
}

