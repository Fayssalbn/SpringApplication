package dev.fenix.application.security.model;


import javax.persistence.*;

@Entity
@Table(name = "sc__role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;
}
