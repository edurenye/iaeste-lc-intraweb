package cat.udl.iaeste.intraweb.models;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by eduard on 23/03/15.
 */
@Entity
@XmlRootElement
public class Company implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String name;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String headquarters;

    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String workPlace;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date foundationDate;

    @NotNull
    private int phoneNumber;

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Date getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(Date foundationDate) {
        this.foundationDate = foundationDate;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
