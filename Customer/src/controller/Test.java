package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.AdvertisementManager;


@Controller
@RequestMapping(value="/user")
public class Test {
	@Autowired
	private AdvertisementManager am;
	

	@RequestMapping(value="/test")
	@ResponseBody
	public void getAllUsers(){
		am.findlastestAdv(2);
	}


}
