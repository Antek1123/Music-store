package antoni.podebski.musicstore.authorization.password;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.common.error.exception.IllegalInputException;
import antoni.podebski.musicstore.operator.model.Operator;
import java.util.Locale;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator {

	private static final int PASSWORD_MINIMUM_LENGTH = 8;
	private static final Pattern CAPITAL_LETTER_PATTERN = Pattern.compile("[A-Z]");
	private static final Pattern LOWERCASE_LETTER_PATTERN = Pattern.compile("[a-z]");
	private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]");
	private static final Pattern SPECIAL_CHARACTERS_PATTERN = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

	public static void validate(Operator operator) {
		String password = operator.getPassword();
		String lowercasePassword = password.toLowerCase(Locale.ROOT);

		if (password.length() < PASSWORD_MINIMUM_LENGTH)
			throw new IllegalInputException(ErrorCode.PASSWORD_TOO_SHORT);

		if (!LOWERCASE_LETTER_PATTERN.matcher(password).find())
			throw new IllegalInputException(ErrorCode.PASSWORD_NOT_CONTAINS_LOWERCASE_LETTER);

		if (!CAPITAL_LETTER_PATTERN.matcher(password).find())
			throw new IllegalInputException(ErrorCode.PASSWORD_NOT_CONTAINS_CAPITAL_LETTER);

		if (!NUMBER_PATTERN.matcher(password).find())
			throw new IllegalInputException(ErrorCode.PASSWORD_NOT_CONTAINS_NUMBER);

		if (!SPECIAL_CHARACTERS_PATTERN.matcher(password).find())
			throw new IllegalInputException(ErrorCode.PASSWORD_NOT_CONTAINS_SPECIAL_CHARACTER);

		if (Pattern.compile(operator.getName().toLowerCase(Locale.ROOT)).matcher(lowercasePassword).find() || Pattern.compile(
				operator.getSurname().toLowerCase(Locale.ROOT)).matcher(lowercasePassword).find())
			throw new IllegalInputException(ErrorCode.PASSWORD_CONTAINS_NAME_OR_SURNAME);
	}

}
