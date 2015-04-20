package cat.udl.iaeste.intraweb.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by eduard on 23/03/15.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email shoud be valid")
    private String email;
    
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Work> works = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Nomination> nominations = new ArrayList<>();

    @NotBlank(message = "This field cannot be blank")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthdate;

    @NotBlank(message = "This field cannot be blank")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date join_date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dismiss_date;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String name;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String surname;
    
    private int points;

    public User(String username, Date birthdate, String email, Date join_date, String name, String surname) {
        this.username = username;
        this.birthdate = birthdate;
        this.email = email;
        this.join_date = join_date;
        this.name = name;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public Date getJoin_date() {
        return join_date;
    }

    public Long getId() {
        return Id;
    }

    public Date getDismiss_date() {
        return dismiss_date;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setDismiss_date(Date dismiss_date) {
        this.dismiss_date = dismiss_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
