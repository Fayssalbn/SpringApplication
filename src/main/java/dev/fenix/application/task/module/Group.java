package dev.fenix.application.task.module;

import javax.persistence.*;

@Entity
@Table(name = "tk__group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


}
