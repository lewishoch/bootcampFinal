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
	private String dishId;
	private String dishName;
	private Integer dishPrice;
	private String dishPhoto;
	
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(int dishPrice) {
		this.dishPrice = dishPrice;
	}
	public String getDishPhoto() {
		return dishPhoto;
	}
	public void setDishPhoto(String dishPhoto) {
		this.dishPhoto = dishPhoto;
	}
	
	
}
