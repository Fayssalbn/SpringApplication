package dev.fenix.application.security.model;


import javax.persistence.*;

//@Entity
//@Table(name = "resume__person")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    String firstName;
    String lastName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
