package dev.fenix.application.resume.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resume__technologie")
public class Technologie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    @Transient
    private MultipartFile file;

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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public Technologie getParent() {
        return parent;
    }

    public void setParent(Technologie parent) {
        this.parent = parent;
    }

    public List<Technologie> getSubTechnologie() {
        return subTechnologie;
    }

    public void setSubTechnologie(List<Technologie> subTechnologie) {
        this.subTechnologie = subTechnologie;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Transient
    public String getLogoImagePath() {
        if (logo == null) return null;
        return "data/technologie-logos/" + id + "/" + logo;
    }
}
