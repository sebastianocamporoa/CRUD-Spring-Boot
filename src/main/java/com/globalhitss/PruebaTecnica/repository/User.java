package com.globalhitss.PruebaTecnica.repository;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "last_name")
    String last_name;
    @Column(name = "email")
    String email;
    @Column(name = "registration_date")
    Date registration_date;
    @Column(name = "status")
    Boolean status;
    @PrePersist
    void preInsert() {
        if (this.status == null)
            this.status = true;
    }
}
