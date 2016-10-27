package po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ShopInfo {
	@Column(nullable=false)
	private String sName;
	
	@Column(nullable=false)
	private String sAddr;
	
	@Column(nullable=false)
	private String sCat;
	
	@Column(nullable=false)
	private Integer sStat;
	
	@Column(nullable=false)
	private String sTel;
	
	@Column(nullable=false)
	private String sLogoPath;

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddr() {
		return sAddr;
	}

	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}

	public String getsCat() {
		return sCat;
	}

	public void setsCat(String sCat) {
		this.sCat = sCat;
	}

	public Integer getsStat() {
		return sStat;
	}

	public void setsStat(Integer sStat) {
		this.sStat = sStat;
	}

	public String getsTel() {
		return sTel;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public String getsLogoPath() {
		return sLogoPath;
	}

	public void setsLogoPath(String sLogoPath) {
		this.sLogoPath = sLogoPath;
	}
	
	
}

