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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
