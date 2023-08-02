package antoni.podebski.musicstore.operator.repository;

import antoni.podebski.musicstore.operator.model.Operator;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Long> {

    boolean existsByEmail(String email);

    @EntityGraph("Operator.withRoles")
    Optional<Operator> findByEmail(String email);

    @EntityGraph("Operator.withRolesAndAddress")
    Optional<Operator> findById(long id);

}
