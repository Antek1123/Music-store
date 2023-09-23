package antoni.podebski.musicstore.product.instrument.dto;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.product.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstrumentDto extends ProductDto {

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private InstrumentTypeDto instrumentType;

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private String serialNumber;

	public InstrumentTypeDto getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentTypeDto instrumentType) {
		this.instrumentType = instrumentType;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
