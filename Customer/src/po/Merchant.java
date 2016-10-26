package po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="merch_account")
public class Merchant {
	@Id
	@GenericGenerator(name="mid",strategy="uuid")
	@GeneratedValue(generator="mid")
	private String mId;
	
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
	
	@Embedded
	private ShopInfo shop;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creDt;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModDt;
	
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
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
	public ShopInfo getShop() {
		return shop;
	}
	public void setShop(ShopInfo shop) {
		this.shop = shop;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getmAge() {
		return mAge;
	}
	public void setmAge(int mAge) {
		this.mAge = mAge;
	}
	public String getmGender() {
		return mGender;
	}
	public void setmGender(String mGender) {
		this.mGender = mGender;
	}
}
