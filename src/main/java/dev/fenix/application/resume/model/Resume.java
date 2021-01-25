package dev.fenix.application.resume.model;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "resume__main")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Date birthday;
    private String job;
    private String presentation;
    private String photo;


    @OneToMany(mappedBy = "resume", fetch = FetchType.LAZY)
    private List<Item> items;



}
