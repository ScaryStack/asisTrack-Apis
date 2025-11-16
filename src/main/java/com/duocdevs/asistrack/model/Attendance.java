package com.duocdevs.asistrack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "fecha", nullable = false)
    private Date date;

    @Column(name = "hora_registro", nullable = false)
    private Date hour;

    private String location;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "USER_userId")
    private User user;
}