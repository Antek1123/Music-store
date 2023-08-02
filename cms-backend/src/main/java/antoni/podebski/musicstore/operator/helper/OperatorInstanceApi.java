package antoni.podebski.musicstore.operator.helper;

import antoni.podebski.musicstore.authorization.principal.OperatorPrincipal;
import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.common.error.exception.UnauthorizedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class OperatorInstanceApi {

	public OperatorPrincipal get() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth instanceof UsernamePasswordAuthenticationToken authToken
				&& authToken.getPrincipal() instanceof OperatorPrincipal operatorPrincipal)
			return operatorPrincipal;

		throw new UnauthorizedException(ErrorCode.OPERATOR_UNAUTHORIZED);
	}

}
