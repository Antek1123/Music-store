package antoni.podebski.musicstore.product.instrument.dto;

import antoni.podebski.musicstore.common.error.ErrorCode;
import jakarta.validation.constraints.NotBlank;

public class InstrumentTypeDto {

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static InstrumentTypeDto of(String name) {
		InstrumentTypeDto instrumentTypeDto = new InstrumentTypeDto();
		instrumentTypeDto.setName(name);

		return instrumentTypeDto;
	}

}
