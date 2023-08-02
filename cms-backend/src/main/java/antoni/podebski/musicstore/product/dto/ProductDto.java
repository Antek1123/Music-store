package antoni.podebski.musicstore.product.dto;

import static antoni.podebski.musicstore.common.date.Dates.DATE_FORMAT_SHORT;

import antoni.podebski.musicstore.common.deserializer.OffsetDateTimeDeserializer;
import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.product.price.ProductState;
import antoni.podebski.musicstore.product.price.dto.PriceDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import jakarta.validation.constraints.NotBlank;
import java.time.OffsetDateTime;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

	private Long id;

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private String name;

	private String description;

	private Set<PriceDto> prices;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT_SHORT)
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime productionDate;

	private double weight;

	@NotBlank(message = ErrorCode.NOT_BLANK)
	private ProductState state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PriceDto> getPrices() {
		return prices;
	}

	public void setPrices(Set<PriceDto> prices) {
		this.prices = prices;
	}

	public OffsetDateTime getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(OffsetDateTime productionDate) {
		this.productionDate = productionDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
		this.state = state;
	}

}
