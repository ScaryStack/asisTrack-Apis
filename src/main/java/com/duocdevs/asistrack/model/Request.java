package com.duocdevs.asistrack.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SOLICITUD")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    private Integer idRequest;

    private String status;

    private String requestType; // ('PERMISSION', 'VACATION')

    @Column(nullable = false)
    private java.time.OffsetDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "USER_userId")
    private User user;

    @OneToOne(mappedBy = "request")
    private Permission permission;

    @OneToOne(mappedBy = "request")
    private Vacation vacation;
}
