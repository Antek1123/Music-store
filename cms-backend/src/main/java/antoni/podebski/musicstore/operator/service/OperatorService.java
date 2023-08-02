package antoni.podebski.musicstore.operator.service;

import antoni.podebski.musicstore.authorization.password.PasswordValidator;
import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.common.error.exception.IllegalInputException;
import antoni.podebski.musicstore.operator.model.Operator;
import antoni.podebski.musicstore.operator.repository.OperatorRepository;
import java.time.OffsetDateTime;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatorService {

    private final static String EMAIL_DELETE_TEMPLATE = "%s_DELETED_%s";

    private final OperatorRepository repository;

    private final PasswordEncoder passwordEncoder;

    public OperatorService(OperatorRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

   public Operator findWithRolesAndAddress(long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalInputException(ErrorCode.OPERATOR_NOT_EXISTS));
   }

    public Operator add(Operator operator) {
        if (repository.existsByEmail(operator.getEmail()))
            throw new IllegalInputException(ErrorCode.OPERATOR_EMAIL_ALREADY_EXIST);

        PasswordValidator.validate(operator);
        operator.setPassword(passwordEncoder.encode(operator.getPassword()));

        return repository.save(operator);
    }

    public List<Operator> findAll() {
        return repository.findAll();
    }

    public void delete(long id) {
        Operator operator = get(id);
        OffsetDateTime now = OffsetDateTime.now();

        operator.setDeletedAt(now);
        operator.setEmail(String.format(EMAIL_DELETE_TEMPLATE, operator.getEmail(), now));
        repository.save(operator);
    }

    private Operator get(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalInputException(ErrorCode.OPERATOR_NOT_EXISTS));
    }

}
