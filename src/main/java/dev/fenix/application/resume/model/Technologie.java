package dev.fenix.application.resume.model;


import javax.persistence.*;

@Entity
@Table(name = "resume__technologie")
public class Technologie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Name;
    private String logo;
    private String url;


}
