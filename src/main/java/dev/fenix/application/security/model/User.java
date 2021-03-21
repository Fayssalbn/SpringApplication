package dev.fenix.application.security.model;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "sc__users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @NotBlank(message = "Name is mandatory")
    //@Size(min = 4, max = 120, message = "message size must be between 2 and 12")
    @Type(type="text")
    @Column(name="user_name")
    @ColumnTransformer(forColumn="user_name", read="LOWER(user_name)", write="LOWER(?)")
    private String userName;

   // @NotBlank(message = "userpassword is mandatory")
   // @Pattern(message="Minimum eight characters, at least one letter and one number", regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$")
    @Size(min = 6, max = 20, message = "message size must be between 6 and 20")
    @Transient
    private String userpassword;

    private String password;


    private boolean active;
    @NotBlank(message = "roles is mandatory")
    private String roles;

    @NotBlank(message = "Name is mandatory")
    @Column(name="name")
    @ColumnTransformer(forColumn="name", read="LOWER(name)", write="LOWER(?)")
    private String name;

    @NotBlank(message = "email is mandatory")
    @Email(message = "Not email")
    private String email;


    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;



    @PrePersist
    protected void onCreate() {
        createDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modifyDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public void CryptPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        this.password = passwordEncoder.encode(this.userpassword);

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
