package cat.udl.iaeste.intraweb.models;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by eduard on 20/04/15.
 */
@Entity
public class OfficerDelegate extends Delegate {
    public OfficerDelegate() {
        super();
    }

    public OfficerDelegate(String username, String password, String email) {
        super(username, password, email);
    }

    public OfficerDelegate(String username, String password, String email, Date birthdate, Date join_date, String name, String surname) {
        super(username, password, email, birthdate, join_date, name, surname);
    }
}
