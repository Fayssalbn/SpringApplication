package dev.fenix.application.resume.model;

import javax.persistence.*;

@Entity
@Table(name = "resume__icon")
public class Icon {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String color;
    private String size;
}
