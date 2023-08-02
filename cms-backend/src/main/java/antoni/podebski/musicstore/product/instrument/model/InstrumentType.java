package antoni.podebski.musicstore.product.instrument.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "instrument_type")
public class InstrumentType {

    @Id
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static InstrumentType of(String name) {
        InstrumentType instrumentType = new InstrumentType();
        instrumentType.setName(name);

        return instrumentType;
    }
}
