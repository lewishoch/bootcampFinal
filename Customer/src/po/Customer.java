package po;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GenericGenerator(name="cid",strategy="uuid")
	@GeneratedValue(generator="cid")
	private String cId;
	private String name;
	private String psd;
	private List<String> address;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creDt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModDt;
	
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
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
