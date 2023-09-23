package antoni.podebski.musicstore.product.instrument.model;

import antoni.podebski.musicstore.product.model.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "instrument")
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
public class Instrument extends Product {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrument_type")
    private InstrumentType instrumentType;

    @Column(name = "serial_number", unique = true)
    private String serialNumber;

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
