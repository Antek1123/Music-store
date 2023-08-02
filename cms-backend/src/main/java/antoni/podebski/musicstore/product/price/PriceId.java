package antoni.podebski.musicstore.product.price;

import antoni.podebski.musicstore.product.model.Product;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class PriceId implements Serializable {

	@Serial
	private static final long serialVersionUID = 12370701374012341L;

	private Currency currency;

	private Product product;

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currency.name(), product.getId());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		final PriceId that = (PriceId) o;
		return this.currency.name().equals(that.currency.name()) && this.product.getId().equals(that.getProduct().getId());
	}

}
