package antoni.podebski.musicstore.product.price;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class ProductToOrderId implements Serializable {

	@Serial
	private static final long serialVersionUID = 1237070170403452341L;

	private long order;

	private long product;

	public long getOrder() {
		return order;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	public long getProduct() {
		return product;
	}

	public void setProduct(long product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		final ProductToOrderId that = (ProductToOrderId) o;
		return this.product == that.product && this.order == that.order;
	}

}
