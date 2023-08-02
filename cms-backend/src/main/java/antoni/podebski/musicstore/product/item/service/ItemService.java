package antoni.podebski.musicstore.product.item.service;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.common.error.exception.NoEntityException;
import antoni.podebski.musicstore.product.item.model.Item;
import antoni.podebski.musicstore.product.item.repository.ItemRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

	private final ItemRepository repository;

	public ItemService(ItemRepository repository) {
		this.repository = repository;
	}

	 public List<Item> findAll() {
		return repository.findAllWithPrices();
	 }

	 public Item getWithPrices(long id) {
		return repository.findByIdWithPrices(id).orElseThrow(() -> new NoEntityException(ErrorCode.ITEM_NOT_EXISTS));
	 }

	 public Item create(Item item) {
		return repository.save(item);
	 }

	 public Item edit(long targetId, Item source) {
		 Item target = getById(targetId);

		 target.setName(source.getName());
		 target.setDescription(source.getDescription());
		 target.setPrices(source.getPrices());
		 target.setProductionDate(source.getProductionDate());
		 target.setWeight(source.getWeight());
		 target.setState(source.getState());

		 return repository.save(target);
	 }

	 public void delete(long itemId) {
		Item item = getById(itemId);

		repository.delete(item);
	 }

	 private Item getById(long id) {
		return repository.findById(id).orElseThrow(() -> new NoEntityException(ErrorCode.ITEM_NOT_EXISTS));
	 }

}
