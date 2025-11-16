package com.duocdevs.asistrack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PERSONA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @Column(name = "idPerson")
    private Integer idPerson;

    @Column(nullable = false, length = 15)
    private String rut;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 12)
    private String phone;

    @OneToOne(mappedBy = "person")
    private User user;
}
