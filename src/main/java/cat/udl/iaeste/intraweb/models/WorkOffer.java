package cat.udl.iaeste.intraweb.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by eduard on 20/04/15.
 */
@Entity
public class WorkOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int minNumWeeks;

    private int maxNumWeeks;

    @NotBlank(message = "This field cannot be blank")
    private String country;

}
