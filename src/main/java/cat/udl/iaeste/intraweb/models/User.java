package cat.udl.iaeste.intraweb.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;

/**
 * Created by eduard on 23/03/15.
 */

@Entity
public class User implements UserDetails {

    @Id
    @NotBlank(message = "Username cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String username;

    @Email(message = "Email shoud be valid")
    private String email;

    @URL
    private String imageUrl;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthdate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date join_date;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dismiss_date;

    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String name;

    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String surname;

    private int points;

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(String username, String email, Date birthdate, Date join_date, String name, String surname) {
        this.username = username;
        this.email = email;
        this.birthdate = birthdate;
        this.join_date = join_date;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("USER");
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    @Override
    public String getUsername() { return username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Date getBirthdate() {
        return birthdate;
    }

    public Date getJoin_date() {
        return join_date;
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
