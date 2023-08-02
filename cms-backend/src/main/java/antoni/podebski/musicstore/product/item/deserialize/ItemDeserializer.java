package antoni.podebski.musicstore.product.item.deserialize;

import antoni.podebski.musicstore.product.deserialize.ProductDeserializer;
import antoni.podebski.musicstore.product.item.dto.ItemDto;
import antoni.podebski.musicstore.product.item.model.Item;

public class ItemDeserializer {

	public static Item deserialize(ItemDto itemDto) {
		Item item = ProductDeserializer.deserialize(itemDto, new Item());

		item.setAvailablePiecesNumber(itemDto.getAvailablePiecesNumber());
		return item;
	}

}
