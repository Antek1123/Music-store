package antoni.podebski.musicstore.product.item.serialize;

import antoni.podebski.musicstore.product.item.dto.ItemDto;
import antoni.podebski.musicstore.product.item.model.Item;
import antoni.podebski.musicstore.product.serialize.ProductSerialize;

public class ItemSerializer {

	public static ItemDto serialize(Item item) {
		ItemDto itemDto = ProductSerialize.serialize(item, new ItemDto());

		itemDto.setAvailablePiecesNumber(item.getAvailablePiecesNumber());
		return itemDto;
	}

}
