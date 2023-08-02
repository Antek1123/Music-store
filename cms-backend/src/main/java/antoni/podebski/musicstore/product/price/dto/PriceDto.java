package antoni.podebski.musicstore.product.price.dto;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.product.price.Currency;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDto {

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private Currency currency;

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private int value;

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static PriceDto of(Currency currency, int value) {
		PriceDto dto = new PriceDto();
		dto.setCurrency(currency);
		dto.setValue(value);

		return dto;
	}

}
