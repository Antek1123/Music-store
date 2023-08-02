package antoni.podebski.musicstore.product.instrument.repository;

import antoni.podebski.musicstore.product.instrument.model.InstrumentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentTypeRepository extends JpaRepository<InstrumentType, String> {

}
