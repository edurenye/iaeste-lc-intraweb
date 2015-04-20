package cat.udl.iaeste.intraweb.models;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by eduard on 23/03/15.
 */
@Entity
public class Delegate extends User {

    public Delegate(String username, Date birthdate, String email, Date join_date, String name, String surname) {
        super(username, birthdate, email, join_date, name, surname);
    }
}
