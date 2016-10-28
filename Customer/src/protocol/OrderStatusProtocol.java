package protocol;

public class OrderStatusProtocol {
	public static final int INVALID = -1;
	public static final int PENDING = 0;
	public static final int ACCEPTED = 1;
	public static final int START_DELIVERY = 2;
	public static final int RECEIVED = 3;
	public static final int UNDER_COMPLAIN = 4;
	public static final int ACCEPT_COMPLAIN = 5;
	public static final int REJECT_COMPLAIN = 6;
	
	public static String getStatusName(int statusCode){
		switch(statusCode){
			case PENDING: return "PENDING";
			case ACCEPTED:  return "ACCEPTED";
			case START_DELIVERY: return "START_DELIVERY";
			case RECEIVED: return "RECEIVED";
			
			default: return "INVALID";
		}
	}
	
	public static int getStatusCode(String statusName){
		switch(statusName.toUpperCase()){
			case "PENDING": return PENDING;
			case "ACCEPTED":  return ACCEPTED;
			case "START_DELIVERY": return START_DELIVERY;
			case "RECEIVED": return RECEIVED;
		
			default: return INVALID;
		}
	}
}
