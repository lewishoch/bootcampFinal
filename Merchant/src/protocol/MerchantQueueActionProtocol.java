package protocol;

public class MerchantQueueActionProtocol {
	public static final int INVALID = -1;
	public static final int REGISTER = 0;
	public static final int APPLY_ADS = 1;
	
	public static String getActionName(int actionCode){
		switch(actionCode){
			case REGISTER: return "REGISTER";
			case APPLY_ADS:  return "APPLY_ADS";
			
			default: return "INVALID";
		}
	}
	
	public static int getActionCode(String actionName){
		switch(actionName.toUpperCase()){
			case "REGISTER": return REGISTER;
			case "APPLY_ADS":  return APPLY_ADS;
		
			default: return INVALID;
		}
	}
}
