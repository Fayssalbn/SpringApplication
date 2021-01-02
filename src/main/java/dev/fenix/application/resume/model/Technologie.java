package dev.fenix.application.resume.model;


import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "resume__technologie")
public class Technologie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String logo;
    private String url;
    private String description;
    private Integer levels;

    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn(name = "parent_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Technologie parent;

    @OneToMany(mappedBy = "parent")
    @NotFound(action = NotFoundAction.IGNORE)
    private List<Technologie> subTechnologie;

    @ManyToMany(mappedBy = "technologies")
    private Set<Item> employees = new HashSet<>();

}
