package cat.udl.iaeste.intraweb.models;


import org.hibernate.validator.constraints.NotEmpty;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

/**
 * Created by eduard on 20/04/15.
 */
@Entity
public class Nomination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty
    @ManyToOne
    private User nominated;

}
