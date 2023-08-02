package antoni.podebski.musicstore.product.instrument.repository;

import antoni.podebski.musicstore.product.instrument.model.Instrument;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

	boolean existsBySerialNumber(String serialNumber);

	@Query("SELECT i FROM Instrument i LEFT JOIN FETCH i.prices LEFT JOIN FETCH i.instrumentType")
	List<Instrument> findAllWithPrices();

	@Query("SELECT i FROM Instrument i LEFT JOIN FETCH i.prices LEFT JOIN FETCH i.instrumentType WHERE i.id = :id")
	Optional<Instrument> findByIdWithPricesAndType(@Param("id") long id);

}
