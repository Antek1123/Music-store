package antoni.podebski.musicstore.product.item.repository;

import antoni.podebski.musicstore.product.item.model.Item;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("SELECT i FROM Item i LEFT JOIN FETCH i.prices")
	List<Item> findAllWithPrices();

	@Query("SELECT i FROM Item i LEFT JOIN FETCH i.prices WHERE i.id = :id")
	Optional<Item> findByIdWithPrices(@Param("id") long id);

}
