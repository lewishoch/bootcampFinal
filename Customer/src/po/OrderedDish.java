package po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ordered_dish")
public class OrderedDish {
	@Id
	@GenericGenerator(name="odid",strategy="uuid")
	@GeneratedValue(generator="odid")
	private String odid;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="did")
	private Dish dish;
	
	@Column(nullable=false)
	private Integer quantity;

	public String getOdid() {
		return odid;
	}

	public void setOdid(String odid) {
		this.odid = odid;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
