package com.duocdevs.asistrack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "INCIDENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIncident;

    @ManyToOne
    @JoinColumn(name = "INCIDENT_TYPE_idTyeIn")
    @JsonBackReference
    private IncidentType incidentType;

    @Column(nullable = false)
    private String reason;

    @Column(name = "hora_registro", nullable = false)
    private Date hour;

    @Column(name = "fecha", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "USER_userId")
    private User user;
}