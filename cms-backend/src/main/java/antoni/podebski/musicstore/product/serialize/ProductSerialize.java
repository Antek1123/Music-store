package antoni.podebski.musicstore.product.serialize;

import antoni.podebski.musicstore.product.dto.ProductDto;
import antoni.podebski.musicstore.product.model.Product;
import antoni.podebski.musicstore.product.price.Price;
import antoni.podebski.musicstore.product.price.dto.PriceDto;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductSerialize {

	public static <T extends Product, R extends ProductDto> R serialize(T product, R productDto) {
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setPrices(serializePrices(product.getPrices()));
		productDto.setProductionDate(product.getProductionDate());
		productDto.setWeight(product.getWeight());
		productDto.setState(product.getState());

		return productDto;
	}

	private static Set<PriceDto> serializePrices(Set<Price> prices) {
		return prices.stream().map(price -> PriceDto.of(price.getCurrency(), price.getValue())).collect(Collectors.toSet());
	}

}
