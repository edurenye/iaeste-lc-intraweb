package cat.udl.iaeste.intraweb.models;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by eduard on 20/04/15.
 */
@Entity
public class CompanyDelegate extends Delegate {
    public CompanyDelegate(String username, Date birthdate, String email, Date join_date, String name, String surname) {
        super(username, birthdate, email, join_date, name, surname);
    }
}
