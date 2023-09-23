package antoni.podebski.musicstore.common.error.dto;

public class ErrorDto {

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static ErrorDto of(String code) {
		ErrorDto errorDto = new ErrorDto();
		errorDto.setCode(code);

		return errorDto;
	}

}
