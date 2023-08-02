package antoni.podebski.musicstore.product.item.controller;

import antoni.podebski.musicstore.product.item.deserialize.ItemDeserializer;
import antoni.podebski.musicstore.product.item.dto.ItemDto;
import antoni.podebski.musicstore.product.item.serialize.ItemSerializer;
import antoni.podebski.musicstore.product.item.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/local/items")
@Tag(name = "Item")
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@GetMapping
	public List<ItemDto> findAll() {
		return itemService.findAll().stream().map(ItemSerializer::serialize).toList();
	}

	@GetMapping("{itemId:\\d+}")
	public ItemDto detail(@PathVariable("itemId") long itemId) {
		return ItemSerializer.serialize(itemService.getWithPrices(itemId));
	}

	@PostMapping
	public ItemDto create(@RequestBody ItemDto itemDto) {
		return ItemSerializer.serialize(itemService.create(ItemDeserializer.deserialize(itemDto)));
	}

	@PutMapping("{itemId:\\d+}")
	public ItemDto edit(@PathVariable("itemId") long itemId, @RequestBody ItemDto itemDto) {
		return ItemSerializer.serialize(itemService.edit(itemId, ItemDeserializer.deserialize(itemDto)));
	}

	@DeleteMapping("{itemId:\\d+}")
	public void delete(@PathVariable("itemId") long itemId)	{
		itemService.delete(itemId);
	}

}
