package com.duocdevs.asistrack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "PERMISO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRequest")
    private Integer idRequest;

    @Column(unique = true)
    private Integer idPermission;

    @Column(nullable = false)
    private String reason;

    @Column(name = "fecha", nullable = false)
    private Date date;

    @Column(name = "hora_registro", nullable = false)
    private Date hour;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idRequest")
    @JsonBackReference
    private Request request;
}