package com.duocdevs.asistrack.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "tipo", nullable = false)
    private String type;

    @OneToMany(mappedBy = "incidentType")
    @JsonManagedReference
    private List<Incident> incidents;
}