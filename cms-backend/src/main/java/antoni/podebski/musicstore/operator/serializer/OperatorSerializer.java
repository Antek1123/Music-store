package antoni.podebski.musicstore.operator.serializer;

import antoni.podebski.musicstore.operator.model.Operator;
import antoni.podebski.musicstore.operator.dto.OperatorDto;

public class OperatorSerializer {

    private final static String PASSWORD_CHARACTERS = "******";

    public static OperatorDto serialize(Operator operator) {
        OperatorDto operatorDto = new OperatorDto();

        operatorDto.setId(operator.getId());
        operatorDto.setName(operator.getName());
        operatorDto.setSurname(operator.getSurname());
        operatorDto.setEmail(operator.getEmail());
        operatorDto.setPassword(PASSWORD_CHARACTERS);

        return operatorDto;
    }
}
