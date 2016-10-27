package po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="merchant")
public class Merchant {
	@Id
	@GenericGenerator(name="mid",strategy="uuid")
	@GeneratedValue(generator="mid")
	private String mid;
	
	@Column(nullable=false)
	private String uname;
	
	@Column(nullable=false)
	private String psd;
	
	@Column(nullable=false)
	private Integer status;
	
	@Column(nullable=false)
	private String mName;
	
	@Column(nullable=false)
	private Integer mAge;
	
	@Column(nullable=false)
	private String mGender;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="mid")
	@JsonIgnore
	private Set<Advertisement> advertisements = new HashSet<Advertisement>();

	@Embedded
	private ShopInfo shop;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creDt;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModDt;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public Integer getmAge() {
		return mAge;
	}

	public void setmAge(Integer mAge) {
		this.mAge = mAge;
	}

	public String getmGender() {
		return mGender;
	}

	public void setmGender(String mGender) {
		this.mGender = mGender;
	}


	public Set<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(Set<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public ShopInfo getShop() {
		return shop;
	}

	public void setShop(ShopInfo shop) {
		this.shop = shop;
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
