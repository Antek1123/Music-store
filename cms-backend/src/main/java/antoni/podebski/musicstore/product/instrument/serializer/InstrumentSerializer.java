package antoni.podebski.musicstore.product.instrument.serializer;

import antoni.podebski.musicstore.product.instrument.dto.InstrumentDto;
import antoni.podebski.musicstore.product.instrument.dto.InstrumentTypeDto;
import antoni.podebski.musicstore.product.instrument.model.Instrument;
import antoni.podebski.musicstore.product.serialize.ProductSerialize;

public class InstrumentSerializer {

	public static InstrumentDto serialize(Instrument instrument) {
		InstrumentDto instrumentDto = ProductSerialize.serialize(instrument, new InstrumentDto());
		instrumentDto.setInstrumentType(InstrumentTypeDto.of(instrument.getInstrumentType().getName()));
		instrumentDto.setSerialNumber(instrument.getSerialNumber());

		return instrumentDto;
	}

}
