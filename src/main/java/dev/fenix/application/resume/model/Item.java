package dev.fenix.application.resume.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "resume__item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String heading;
    private String section;
    private Date dateStart;
    private Date dateEnd;
    private String description;
    private String footing;
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn(name = "icon_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Icon icon ;
    private Boolean hasDuration ;
    private Boolean active ;
    private String location ;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "resume__item_technologie",
            joinColumns = { @JoinColumn(name = "item_id") },
            inverseJoinColumns = { @JoinColumn(name = "technologie_id") }
    )
    Set<Technologie> technologies = new HashSet<>();
    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn(name = "resume_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Technologie resume;




}
