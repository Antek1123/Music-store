package antoni.podebski.musicstore.product.instrument.dto;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.product.dto.ProductDto;
import jakarta.validation.constraints.NotBlank;

public class InstrumentDto extends ProductDto {

	private Integer producedNumber;

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private InstrumentTypeDto instrumentType;

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private String serialNumber;

	public Integer getProducedNumber() {
		return producedNumber;
	}

	public void setProducedNumber(Integer producedNumber) {
		this.producedNumber = producedNumber;
	}

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
