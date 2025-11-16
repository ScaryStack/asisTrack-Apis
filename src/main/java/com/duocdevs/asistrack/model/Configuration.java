package com.duocdevs.asistrack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONFIGURACION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Configuration {
    @Id
    @Column(name = "CONFIGURACION_ID")
    private Integer idConfig;

    private Integer theme;

    @OneToOne
    @JoinColumn(name = "USER_userId")
    private User user;
}
