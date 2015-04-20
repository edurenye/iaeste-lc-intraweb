package cat.udl.iaeste.intraweb.repositories;

import cat.udl.iaeste.intraweb.models.Delegate;
import cat.udl.iaeste.intraweb.models.User;
import cat.udl.iaeste.intraweb.models.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by eduard on 23/03/15.
 */
public interface WorkRepository extends JpaRepository<Work, Long> {

    List<Work> findWorksByWorker(@Param("worker") User worker);
    List<Work> findWorksByDelegate(@Param("delegate") Delegate delegate);

}
