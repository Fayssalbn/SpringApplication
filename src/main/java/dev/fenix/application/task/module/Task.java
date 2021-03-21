package dev.fenix.application.task.module;


import dev.fenix.application.person.module.Person;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tk__task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Date startDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "priority_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Priority priority;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "statues_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Statues statues;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "author_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Person author;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "assigned_to_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Person assignedTo;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "group_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Group group;

    private Double percent;
    @Column(name = "icon", length = 30)
    private String icon;
    private Date completeDate;
    private Date endDate;
    @Column(name = "is_repeat", columnDefinition = "BOOLEAN")
    private Boolean repeat;


    @Column(name = "is_updated", columnDefinition = "BOOLEAN")
    private Boolean isUpdated;
    @Column(name = "is_synchronised", columnDefinition = "BOOLEAN")
    private Boolean isSynchronised;



}
