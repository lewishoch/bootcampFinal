package po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="order")
public class Order {
	@Id
	@GenericGenerator(name="oid",strategy="uuid")
	@GeneratedValue(generator="oid")
	private String oId;
	
	@OneToOne(mappedBy="cId",cascade =CascadeType.PERSIST)
	private Customer customer;

	
	@OneToOne(mappedBy="mId",cascade =CascadeType.PERSIST)
	private Merchant merchant;
	
	@OneToMany(mappedBy="odId",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Set<OrderedDish> dishes = new HashSet<OrderedDish>();
	
	@Column(nullable=false)
	private Integer status;
	

	private String comment;
	
	private String reply;
}
