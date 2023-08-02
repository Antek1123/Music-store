package antoni.podebski.musicstore.product.item.model;

import antoni.podebski.musicstore.product.model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
public class Item extends Product {

	@Column(name = "available_pieces_number")
	private int availablePiecesNumber;

	public int getAvailablePiecesNumber() {
		return availablePiecesNumber;
	}

	public void setAvailablePiecesNumber(int availablePiecesNumber) {
		this.availablePiecesNumber = availablePiecesNumber;
	}

}
