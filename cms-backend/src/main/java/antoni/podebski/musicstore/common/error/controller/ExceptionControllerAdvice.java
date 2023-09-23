package antoni.podebski.musicstore.common.error.controller;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.common.error.dto.ErrorDto;
import antoni.podebski.musicstore.common.error.exception.UnauthorizedException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(UnauthorizedException.class)
	public ErrorDto unauthroziedException(UnauthorizedException unauthorizedException, HttpServletResponse response) {
		response.setStatus(HttpStatus.FORBIDDEN.value());
		return ErrorDto.of(unauthorizedException.getMessage());
	}

	@ExceptionHandler(Throwable.class)
	public ErrorDto throwable(Throwable throwable, HttpServletResponse response) {
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ErrorDto.of(ErrorCode.UNKNOWN_SERVER_ERROR);
	}


}
