package cat.udl.iaeste.intraweb.models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by eduard on 20/04/15.
 */
@Entity
public class Nomination {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "This field cannot be blank")
    private User worker;

}
