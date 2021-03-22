package dev.fenix.application.business.module;

import dev.fenix.application.person.module.Person;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bz__team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "leader_id", nullable = false, insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Person leader;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "bz__team_person",
            joinColumns = { @JoinColumn(name = "team_id") },
            inverseJoinColumns = { @JoinColumn(name = "person_id") }
    )
    private Set<Person> people = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getLeader() {
        return leader;
    }

    public void setLeader(Person leader) {
        this.leader = leader;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }
}
