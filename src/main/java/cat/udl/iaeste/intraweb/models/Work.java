package cat.udl.iaeste.intraweb.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by eduard on 23/03/15.
 */
@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private int points;

    private boolean finished = false;

    @ManyToOne
    private User worker;

}
