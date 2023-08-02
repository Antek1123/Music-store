package antoni.podebski.musicstore.common.error.exception;

public class UnauthorizedException extends RuntimeException {

	public UnauthorizedException(String code) {
		super(code);
	}

}
