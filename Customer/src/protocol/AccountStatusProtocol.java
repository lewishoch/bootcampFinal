package protocol;

public class AccountStatusProtocol {
	public static final int INVALID = -1;
	public static final int PENDING = 0;
	public static final int ACCEPTED = 1;
	public static final int REJECTED = 2;
	public static final int FROZON = 3;
	
	public static String getStatusName(int statusCode){
		switch(statusCode){
			case ACCEPTED: return "ACCEPTED";
			case PENDING:  return "PENDING";
			case REJECTED: return "REJECTED";
			case FROZON:   return "FROZON";
			
			default: return "INVALID";
		}
	}
	
	public static int getStatusCode(String statusName){
		switch(statusName.toUpperCase()){
			case "ACCEPTED": return ACCEPTED;
			case "PENDING":  return PENDING;
			case "REJECTED": return REJECTED;
			case "FROZON":   return FROZON;
		
			default: return INVALID;
		}
	}
}
