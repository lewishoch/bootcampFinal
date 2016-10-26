package po;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	@Column(nullable=false)
	private Customer customer;
	
	@Column(nullable=false)
	private Merchant merchant;
	
	private List<OrderedDish> dishes;
	
	@Column(nullable=false)
	private Integer status;
	
	private String comment;
	
	private String reply;
}
