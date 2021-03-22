package dev.fenix.application.business.module;

import dev.fenix.application.person.module.Person;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bz__staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "job_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Job name;
    private Date startDate;
    private Date endDate;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "personnel_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Person personnel = new Person();
}
