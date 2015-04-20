package cat.udl.iaeste.intraweb.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

/**
 * Created by eduard on 23/03/15.
 */
@Entity
public class Company {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String name;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String headquarters;

    @NotBlank(message = "This field cannot be blank")
    @Size(max = 256, message = "Content maximum length is {max} characters long")
    private String workPlace;

}
