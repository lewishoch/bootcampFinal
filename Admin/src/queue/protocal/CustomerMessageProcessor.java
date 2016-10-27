package queue.protocal;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerMessageProcessor {
	public static CustomerMessage process(String jsonStr) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		CustomerMessage msg = mapper.readValue(jsonStr, CustomerMessage.class);
		return msg;
	}
	
	public static String construct(CustomerMessage msg) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(msg);
//		System.out.println(jsonStr);
		return jsonStr;
	}
}
