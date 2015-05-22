package cat.udl.iaeste.intraweb.models;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by eduard on 20/04/15.
 */
@Entity
public class SummerDelegate extends Delegate {
    public SummerDelegate() {
        super();
    }

    public SummerDelegate(String username, String password, String email) {
        super(username, password, email);
    }

    public SummerDelegate(String username, String password, String email, Date birthdate, Date join_date, String name, String surname) {
        super(username, password, email, birthdate, join_date, name, surname);
    }
}
