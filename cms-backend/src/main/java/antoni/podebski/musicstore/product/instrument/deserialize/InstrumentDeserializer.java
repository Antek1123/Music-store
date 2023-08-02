package antoni.podebski.musicstore.product.instrument.deserialize;

import antoni.podebski.musicstore.product.deserialize.ProductDeserializer;
import antoni.podebski.musicstore.product.instrument.dto.InstrumentDto;
import antoni.podebski.musicstore.product.instrument.model.Instrument;
import antoni.podebski.musicstore.product.instrument.model.InstrumentType;

public class InstrumentDeserializer {

	public static Instrument deserialize(InstrumentDto instrumentDto) {
		Instrument instrument = ProductDeserializer.deserialize(instrumentDto, new Instrument());
		instrument.setProducedNumber(instrumentDto.getProducedNumber());
		instrument.setSerialNumber(instrumentDto.getSerialNumber());
		instrument.setInstrumentType(InstrumentType.of(instrumentDto.getInstrumentType().getName()));

		return instrument;
	}

}
