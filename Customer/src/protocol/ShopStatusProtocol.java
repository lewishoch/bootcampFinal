package protocol;

public class ShopStatusProtocol {
	public static final int INVALID = -1;
	public static final int OPENED = 0;
	public static final int CLOSED = 1;
	public static final int PREORDERED = 2;
	
	public static String getStatusName(int statusCode){
		switch(statusCode){
			case OPENED: return "OPENED";
			case CLOSED:  return "CLOSED";
			case PREORDERED: return "PREORDERED";
			
			default: return "INVALID";
		}
	}
	
	public static int getStatusCode(String statusName){
		switch(statusName.toUpperCase()){
			case "OPENED": return OPENED;
			case "CLOSED":  return CLOSED;
			case "PREORDERED": return PREORDERED;
		
			default: return INVALID;
		}
	}
}
