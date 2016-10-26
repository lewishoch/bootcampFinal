package po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
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
	
	
	
}
