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
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFooting() {
        return footing;
    }

    public void setFooting(String footing) {
        this.footing = footing;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Boolean getHasDuration() {
        return hasDuration;
    }

    public void setHasDuration(Boolean hasDuration) {
        this.hasDuration = hasDuration;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Technologie> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technologie> technologies) {
        this.technologies = technologies;
    }

    public Technologie getResume() {
        return resume;
    }

    public void setResume(Technologie resume) {
        this.resume = resume;
    }
}
