package po;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="dish")
public class Dish {
	@Id
	@GenericGenerator(name="did",strategy="uuid")
	@GeneratedValue(generator="did")
	private String did;
	private String dishName;
	private Integer dishPrice;
	private String dishPhoto;
	@ManyToOne(targetEntity=Merchant.class,cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.EAGER)
	@JoinColumn(name="mid")
	@JsonBackReference
	private Merchant merchant;
	private String category;
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public Integer getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(Integer dishPrice) {
		this.dishPrice = dishPrice;
	}
	public String getDishPhoto() {
		return dishPhoto;
	}
	public void setDishPhoto(String dishPhoto) {
		this.dishPhoto = dishPhoto;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
