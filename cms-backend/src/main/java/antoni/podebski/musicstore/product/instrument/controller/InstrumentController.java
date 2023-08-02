package antoni.podebski.musicstore.product.instrument.controller;

import antoni.podebski.musicstore.product.instrument.deserialize.InstrumentDeserializer;
import antoni.podebski.musicstore.product.instrument.dto.InstrumentDto;
import antoni.podebski.musicstore.product.instrument.dto.InstrumentTypeDto;
import antoni.podebski.musicstore.product.instrument.model.InstrumentType;
import antoni.podebski.musicstore.product.instrument.serializer.InstrumentSerializer;
import antoni.podebski.musicstore.product.instrument.service.InstrumentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/local/instruments")
@Tag(name = "Instrument")
public class InstrumentController {

	private final InstrumentService instrumentService;

	public InstrumentController(InstrumentService instrumentService) {
		this.instrumentService = instrumentService;
	}

	@GetMapping
	public List<InstrumentDto> listAll() {
		return instrumentService.findAll().stream().map(InstrumentSerializer::serialize).toList();
	}

	@GetMapping("{instrumentId:\\d+}")
	public InstrumentDto detail(@PathVariable("instrumentId") long instrumentId) {
		return InstrumentSerializer.serialize(instrumentService.findById(instrumentId));
	}

	@PostMapping
	public InstrumentDto create(@RequestBody InstrumentDto instrumentDto) {
		return InstrumentSerializer.serialize(instrumentService.create(InstrumentDeserializer.deserialize(instrumentDto)));
	}

	@PutMapping("{instrumentId:\\d+}")
	public InstrumentDto edit(@PathVariable("instrumentId") long instrumentId, @RequestBody InstrumentDto instrumentDto) {
		return InstrumentSerializer.serialize(instrumentService.edit(instrumentId, InstrumentDeserializer.deserialize(instrumentDto)));
	}

	@DeleteMapping("{instrumentId:\\d+}")
	public void delete(@PathVariable("instrumentId") long instrumentId)	{
		instrumentService.delete(instrumentId);
	}

	@GetMapping("types")
	public List<InstrumentTypeDto> listAllTypes() {
		return instrumentService.findAllTypes().stream().map(InstrumentType::getName).map(InstrumentTypeDto::of).toList();
	}

	@PostMapping("types")
	public InstrumentTypeDto createType(@RequestBody InstrumentTypeDto instrumentTypeDto) {
		return InstrumentTypeDto.of(instrumentService.createType(instrumentTypeDto.getName()).getName());
	}

	@DeleteMapping("types/{type}")
	public void deleteType(@PathVariable("type") String type) {
		instrumentService.deleteType(Strings.toRootUpperCase(type));
	}

}
