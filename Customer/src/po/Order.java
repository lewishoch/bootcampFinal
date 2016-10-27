package po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GenericGenerator(name="oid",strategy="uuid")
	@GeneratedValue(generator="oid")
	private String oid;
	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cid")
	private Customer customer;

	

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="mid")
	private Merchant merchant;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="oid")
	@JsonManagedReference
	private Set<OrderedDish> dishes = new HashSet<OrderedDish>();
	
	
	@Column(nullable=false)
	private Integer status;
	
	private Integer rating;

	private String comments;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creDt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModDt;
	
//	private String reply;

	public Date getCreDatet() {
		return creDt;
	}

	public void setCreDt1(Date creDt) {
		this.creDt = creDt;
	}

	public Date getDateLastModDt() {
		return lastModDt;
	}

	public void setLastModDt1(Date lastModDt) {
		this.lastModDt = lastModDt;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public Set<OrderedDish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<OrderedDish> dishes) {
		this.dishes = dishes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

//	public String getReply() {
//		return reply;
//	}
//
//	public void setReply(String reply) {
//		this.reply = reply;
//	}
	
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Date getCreDt() {
		return creDt;
	}

	public void setCreDt(Date creDt) {
		this.creDt = creDt;
	}

	public Date getLastModDt() {
		return lastModDt;
	}

	public void setLastModDt(Date lastModDt) {
		this.lastModDt = lastModDt;
	}
	
	
	
	
	
}
