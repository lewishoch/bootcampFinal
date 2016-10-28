package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.AdminAccount;
import service.AdminManager;

@Controller
public class AdminController {
	@Autowired
	private AdminManager am;
	
	@RequestMapping(value="/login", method = {RequestMethod.POST})
	public void login(String uname, String psd, HttpServletRequest request, HttpServletResponse resp) throws Exception{
		System.out.println(uname+"..."+psd);
		HttpSession sen = request.getSession(true);
		AdminAccount aa = new AdminAccount();
		aa.setUname(uname);
		aa.setPsd(psd);
		if(am.isValidate(aa)){
			sen.setAttribute("isLogin", true);
			sen.setAttribute("name", aa.getUname());
			resp.sendRedirect("home.html");
		}		
		else
			resp.sendRedirect("index.html");
	}
	
	@RequestMapping(value="/logout", method={RequestMethod.GET})
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse resp) throws Exception
	{
		HttpSession session = request.getSession(false);
		if (session != null)
		    session.invalidate();
		resp.sendRedirect("index.html");
	}
	
}
