package antoni.podebski.musicstore.product.deserialize;

import antoni.podebski.musicstore.product.dto.ProductDto;
import antoni.podebski.musicstore.product.model.Product;
import antoni.podebski.musicstore.product.price.Price;
import antoni.podebski.musicstore.product.price.dto.PriceDto;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductDeserializer {

	public static <T extends ProductDto, R extends Product> R deserialize(T productDto, R product) {
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setProductionDate(productDto.getProductionDate());
		product.setWeight(productDto.getWeight());
		product.setState(productDto.getState());

		product.setPrices(deserializePrice(productDto.getPrices(), product));

		return product;
	}

	public static Set<Price> deserializePrice(Set<PriceDto> prices, Product product) {
		return Optional.ofNullable(prices).orElse(Collections.emptySet()).stream().map(priceDto -> {
			Price price = new Price();
			price.setCurrency(priceDto.getCurrency());
			price.setValue(priceDto.getValue());
			price.setProduct(product);

			return price;
		}).collect(Collectors.toSet());
	}

}
