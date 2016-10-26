package protocal;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerMessageProcessor {
	public static MerchantMessage process(String jsonStr) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		MerchantMessage msg = mapper.readValue(jsonStr, MerchantMessage.class);
		return msg;
	}
	
	public static String construct(MerchantMessage msg) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(msg);
//		System.out.println(jsonStr);
		return jsonStr+"\n";
	}
}
