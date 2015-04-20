package cat.udl.iaeste.intraweb.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

/**
 * Created by eduard on 20/04/15.
 */
@Entity
public class WorkOffer {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int minNumWeeks;

    private int maxNumWeeks;

    @NotBlank(message = "This field cannot be blank")
    private String country;

}
