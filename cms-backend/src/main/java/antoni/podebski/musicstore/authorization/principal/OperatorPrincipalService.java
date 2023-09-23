package antoni.podebski.musicstore.authorization.principal;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.operator.model.Operator;
import antoni.podebski.musicstore.operator.repository.OperatorRepository;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class OperatorPrincipalService implements UserDetailsService {

	private final OperatorRepository repository;

	public OperatorPrincipalService(OperatorRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final Operator operator = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(ErrorCode.EMAIL_INVALID));

		operator.setLastLoggedAt(OffsetDateTime.now());
		repository.save(operator);

		return new OperatorPrincipal(operator, Optional.ofNullable(operator.getRoles())
				.orElse(Collections.emptySet())
				.stream()
				.map(operatorToRole -> (GrantedAuthority) () -> operatorToRole.getRole().toString())
				.collect(Collectors.toSet()));
	}

}
