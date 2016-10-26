package protocal;

public class MerchantMessage {
	public static final int REGISTER = 1;
	public static final int APPLY_ADS = 2;
	
	private String id;
	private int action;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	
}
