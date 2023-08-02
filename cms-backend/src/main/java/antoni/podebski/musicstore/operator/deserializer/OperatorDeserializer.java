package antoni.podebski.musicstore.operator.deserializer;

import antoni.podebski.musicstore.operator.model.Operator;
import antoni.podebski.musicstore.operator.dto.OperatorDto;

public class OperatorDeserializer {

    public static Operator fromDto(OperatorDto operatorDto) {
        Operator operator = new Operator();

        operator.setId(operatorDto.getId());
        operator.setName(operatorDto.getName());
        operator.setSurname(operatorDto.getSurname());
        operator.setEmail(operatorDto.getEmail());
        operator.setPassword(operatorDto.getPassword());

        return operator;
    }

}
