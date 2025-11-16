package com.duocdevs.asistrack.model;

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
    @Column(name = "idRequest")
    private Integer idRequest;

    @Column(unique = true)
    private Integer idPermission;

    @Column(nullable = false, length = 500)
    private String reason;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private Date hour;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idRequest")
    private Request request;
}