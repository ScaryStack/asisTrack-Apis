package com.duocdevs.asistrack.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "VACACION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vacation {
    @Id
    @Column(name = "idRequest")
    private Integer idRequest;

    @Column(unique = true)
    private Integer idVacation;

    private Integer daysAvailable;

    private Date dateStart;
    private Date dateFinish;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idRequest")
    @JsonBackReference
    private Request request;
}