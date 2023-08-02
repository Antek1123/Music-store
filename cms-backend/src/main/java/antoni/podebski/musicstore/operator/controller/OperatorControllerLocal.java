package antoni.podebski.musicstore.operator.controller;

import antoni.podebski.musicstore.operator.deserializer.OperatorDeserializer;
import antoni.podebski.musicstore.operator.dto.OperatorDto;
import antoni.podebski.musicstore.operator.helper.OperatorInstanceApi;
import antoni.podebski.musicstore.operator.serializer.OperatorSerializer;
import antoni.podebski.musicstore.operator.service.OperatorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/local/operators")
@Tag(name = "Operator")
public class OperatorControllerLocal {

    private final OperatorService operatorService;

    private final OperatorInstanceApi operatorInstanceApi;

    public OperatorControllerLocal(OperatorService operatorService, OperatorInstanceApi operatorInstanceApi) {
        this.operatorService = operatorService;
        this.operatorInstanceApi = operatorInstanceApi;
    }

    @GetMapping("details")
    public OperatorDto details() {
        return OperatorSerializer.serialize(operatorInstanceApi.get().getOperator());
    }

    @GetMapping
    public List<OperatorDto>  findAll() {
        return operatorService.findAll().stream().map(OperatorSerializer::serialize).toList();
    }

    @GetMapping("{operatorId:\\d+}")
    public OperatorDto detail(@PathVariable("operatorId") long operatorId) {
        return OperatorSerializer.serialize(operatorService.findWithRolesAndAddress(operatorId));
    }

    @PostMapping
    public OperatorDto add(@Valid @RequestBody OperatorDto operatorDto) {
        return OperatorSerializer.serialize(operatorService.add(OperatorDeserializer.fromDto(operatorDto)));
    }

    @DeleteMapping("{operatorId:\\d+}")
    public void delete(@PathVariable("operatorId") long operatorid) {
        operatorService.delete(operatorid);
    }

}
