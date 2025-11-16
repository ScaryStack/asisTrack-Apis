package com.duocdevs.asistrack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "TIPO_INCIDENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTyeIn;

    @Column(nullable = false, length = 30)
    private String type;

    @OneToMany(mappedBy = "incidentType")
    private List<Incident> incidents;
}