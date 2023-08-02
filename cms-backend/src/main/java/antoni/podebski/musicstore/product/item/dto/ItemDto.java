package antoni.podebski.musicstore.product.item.dto;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.product.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDto extends ProductDto {

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private int availablePiecesNumber;

	public int getAvailablePiecesNumber() {
		return availablePiecesNumber;
	}

	public void setAvailablePiecesNumber(int availablePiecesNumber) {
		this.availablePiecesNumber = availablePiecesNumber;
	}

}
