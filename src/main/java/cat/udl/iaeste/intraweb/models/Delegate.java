package cat.udl.iaeste.intraweb.models;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by eduard on 23/03/15.
 */
@Entity
public class Delegate extends User {

    public Delegate() {
        super();
    }

    public Delegate(String username, String password, String email) {
        super(username, email);
    }

    public Delegate(String username, String password, String email, Date birthdate, Date join_date, String name, String surname) {
        super(username, email, birthdate, join_date, name, surname);
    }
}
