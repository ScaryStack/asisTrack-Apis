package com.duocdevs.asistrack.model;

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
    private IncidentType incidentType;

    @Column(nullable = false, length = 999)
    private String reason;

    @Column(nullable = false)
    private Date hour;

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "USER_userId")
    private User user;
}