package po;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ordered_dish")
public class OrderedDish {
	@Id
	@GenericGenerator(name="odid",strategy="uuid")
	@GeneratedValue(generator="odid")
	private String odId;
	
	@OneToOne(mappedBy="dishId",cascade =CascadeType.PERSIST)
	private Dish dish;
	
	@Column(nullable=false)
	private Integer quantity;
}
