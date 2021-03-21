package dev.fenix.application.task.module;

import javax.persistence.*;

@Entity
@Table(name = "tk__statues")
public class Statues {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
