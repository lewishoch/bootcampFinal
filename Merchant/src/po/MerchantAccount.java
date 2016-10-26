package po;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="merch_account")
public class MerchantAccount {
	@Id
	@GenericGenerator(name="mid",strategy="uuid")
	@GeneratedValue(generator="mid")
	private String m_id;
	private String uname;
	private String psd;
	private int status;
	private String mName;
	private int mAge;
	private String mGender;
	private ShopInfo shop;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creDt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModDt;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
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
