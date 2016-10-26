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
@Table(name="admin_account")
public class AdminAccount {
	@Id
	@GenericGenerator(name="aid",strategy="uuid")
	@GeneratedValue(generator="aid")
	private String a_id;
	String uname;
	String psd;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creDt;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModDt;
	
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String a_id) {
		this.a_id = a_id;
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
