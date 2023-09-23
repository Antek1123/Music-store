package antoni.podebski.musicstore.product.instrument.service;

import antoni.podebski.musicstore.common.error.ErrorCode;
import antoni.podebski.musicstore.common.error.exception.IllegalInputException;
import antoni.podebski.musicstore.common.error.exception.NoEntityException;
import antoni.podebski.musicstore.product.instrument.model.Instrument;
import antoni.podebski.musicstore.product.instrument.model.InstrumentType;
import antoni.podebski.musicstore.product.instrument.repository.InstrumentRepository;
import antoni.podebski.musicstore.product.instrument.repository.InstrumentTypeRepository;
import antoni.podebski.musicstore.product.price.PriceRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService {

	private final InstrumentRepository repository;

	private final InstrumentTypeRepository instrumentTypeRepository;

	private final PriceRepository priceRepository;

	public InstrumentService(InstrumentRepository repository, InstrumentTypeRepository instrumentTypeRepository,
			PriceRepository priceRepository) {
		this.repository = repository;
		this.instrumentTypeRepository = instrumentTypeRepository;
		this.priceRepository = priceRepository;
	}

	public List<Instrument> findAll() {
		return repository.findAllWithPrices();
	}

	public Instrument findById(long id) {
		return repository.findByIdWithPricesAndType(id).orElseThrow(() -> new NoEntityException(ErrorCode.INSTRUMENT_NOT_EXISTS));
	}

	public Instrument create(Instrument instrument) {
		validateSerialNumber(instrument.getSerialNumber());

		return repository.save(instrument);
	}

	public Instrument edit(long targetId, Instrument source) {
		Instrument target = getById(targetId);

		if (!target.getSerialNumber().equals(source.getSerialNumber()))
			validateSerialNumber(source.getSerialNumber());

		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setProductionDate(source.getProductionDate());
		target.setWeight(source.getWeight());
		target.setState(source.getState());
		target.setSerialNumber(source.getSerialNumber());
		target.setInstrumentType(source.getInstrumentType());
		priceRepository.saveAll(source.getPrices()); //merge price napisać

		return repository.save(target);
	}

	public void delete(long targetId) {
		Instrument instrument = getById(targetId);

		repository.delete(instrument);
	}

	public List<InstrumentType> findAllTypes() {
		return instrumentTypeRepository.findAll();
	}

	public InstrumentType createType(String name) {
		if (instrumentTypeRepository.existsById(name))
			throw new IllegalInputException(ErrorCode.INSTRUMENT_TYPE_EXISTS);

		return instrumentTypeRepository.save(InstrumentType.of(name));
	}

	public void deleteType(String name) {
		InstrumentType instrumentType = instrumentTypeRepository.findById(name)
				.orElseThrow(() -> new NoEntityException(ErrorCode.INSTRUMENT_TYPE_NOT_EXISTS));

		instrumentTypeRepository.delete(instrumentType);
	}

	private void validateSerialNumber(String serialNumber) {
		if (repository.existsBySerialNumber(serialNumber))
			throw new IllegalInputException(ErrorCode.INSTRUMENT_EXISTS);
	}

	private Instrument getById(long id) {
		return repository.findById(id).orElseThrow(() -> new NoEntityException(ErrorCode.INSTRUMENT_NOT_EXISTS));
	}

}
