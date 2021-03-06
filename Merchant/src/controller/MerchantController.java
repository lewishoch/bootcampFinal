package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import po.Merchant;
import po.ShopInfo;
import producer.util.MerchantQueueProducerUtil;
import protocol.AccountStatusProtocol;
import protocol.GenderProtocol;
import protocol.ShopCategoryProtocol;
import protocol.ShopStatusProtocol;
import queue.protocal.MerchantMessage;
import service.MerchantManager;

@Controller
public class MerchantController {
	
	@Autowired
	private MerchantManager mm;
	
	@RequestMapping(value="/login", method={RequestMethod.POST})
	@ResponseBody
	public Merchant login(String uname, String psd, HttpServletRequest request, HttpServletResponse resp) throws Exception {
		HttpSession sen = request.getSession(true);
		
		Merchant m = mm.loadMerchantByUname(uname);
		
		if(m == null)
		{
			resp.sendRedirect("index.html");
			return null;
		}
		
		if(m != null && m.getPsd().equals(psd))
		{
			//Web Services
			String merchantString = "";
			Client client = Client.create();
			MultivaluedMap<String, String> params=new MultivaluedMapImpl();
			params.add("id", m.getMid());
			client.setReadTimeout(1000);
			WebResource wr = client
					.resource("http://10.222.29.181:8081/Admin/m/getMerchant");
			merchantString = wr
					.queryParams(params)
					.accept(MediaType.APPLICATION_JSON_TYPE)
					.get(String.class);
			System.out.println(merchantString);
			
			ObjectMapper mapper = new ObjectMapper();
			Merchant merchant = mapper.readValue(merchantString, Merchant.class);
			mm.updateMerchant(merchant);
			
			if (merchant.getStatus() == AccountStatusProtocol.ACCEPTED) {
				//Login
				sen.setAttribute("isLogin", true);
				sen.setAttribute("uuid", m.getMid());
				System.out.println("Login success");
				resp.sendRedirect("dishEdit.html");
				return m;
			}
		}
		
		resp.sendRedirect("index.html");
		return null;
	}
	
	@RequestMapping(value="/signup", method={RequestMethod.POST})
	@ResponseBody
	public Merchant signup(String uname, String psd, String mName, String mGender, String sName, String sAddr, String sCat, String sStat, String sTel, String sLogoPath, HttpServletRequest request, HttpServletResponse resp) throws IOException
	{
		HttpSession sen = request.getSession(true);
		
		Merchant m = mm.loadMerchantByUname(uname);
		
		if(m == null)
		{
			// no existing merchant using the registering name
			Merchant newM = new Merchant();
			newM.setUname(uname);
			newM.setPsd(psd);
			newM.setStatus(AccountStatusProtocol.PENDING);
			newM.setmName("Merchant Name");
			newM.setmAge(35);
			if (mGender.equals("M"))
				newM.setmGender(GenderProtocol.MALE);
			else if (mGender.equals("F"))
				newM.setmGender(GenderProtocol.FEMALE);
			newM.setRating(0);
			newM.setNumOfOrder(0);
			ShopInfo shop = new ShopInfo();
			shop.setsName(sName);
			shop.setsAddr(sAddr);
			shop.setsCat(sCat);
			System.out.println(sStat+"..."+request.getParameter("sStat"));
			if ("O".equals(request.getParameter("sStat")))
				shop.setsStat(ShopStatusProtocol.OPENED);
			else if ("C".equals(request.getParameter("sStat")))
				shop.setsStat(ShopStatusProtocol.CLOSED);
			else if ("P".equals(request.getParameter("sStat")))
				shop.setsStat(ShopStatusProtocol.PREORDERED);
			else
				shop.setsStat(ShopStatusProtocol.INVALID);
			shop.setsTel(sTel);
			shop.setsLogoPath("need change");
			newM.setShop(shop);
			newM.setCreDt(new Date());
			newM.setLastModDt(new Date());
			
			Merchant mWithId = null;
			//Send Register message to  
			if ((mWithId = mm.addMerchant(newM)) != null) {
				MerchantQueueProducerUtil.queue(MerchantMessage.REGISTER, mWithId.getMid());
				sen.setAttribute("isLogin", true);
				sen.setAttribute("uuid", mWithId.getMid());
				resp.sendRedirect("index.html");
			}
			
			return mWithId;
		}
		else
		{
			// have existing merchant
			resp.sendRedirect("index.html");
			return null;
		}
	}
	
	@RequestMapping(value="/logout", method={RequestMethod.GET})
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse resp) throws IOException
	{
		System.out.println("logout controller");
		HttpSession session = request.getSession(false);
		if (session != null)
		{
		    session.invalidate();
		    System.out.println("lougout success");
		    
		}
		resp.sendRedirect("index.html");
	}
	
	@RequestMapping(value="/loadMerchantById", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant loadMerchantById(HttpServletRequest request, HttpServletResponse resp) {
		HttpSession s = request.getSession();
		String mid;
		if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
		{
			return mm.loadMerchantById(mid);
		}
		return null;
	}
	
	@RequestMapping(value="/getMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant loadMerchantById(String mid) {
		return mm.loadMerchantById(mid);
	}
	
	@RequestMapping(value="loadMerchantByUname", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant loadMerchantByUname(String uname) {
		return mm.loadMerchantByUname(uname);
	}
	
	@RequestMapping(value="addMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant addMerchant(Merchant m) {
		try {
			return mm.addMerchant(m);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="updateMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant updateMerchant(String uname, String psd, String sAddr, String sCat, String sTel, HttpServletRequest request,HttpServletResponse resp) {		
		HttpSession s = request.getSession();
		String mid;
		if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
		{
			Merchant m = mm.loadMerchantById(mid);
			m.setUname(uname);
			m.setPsd(psd);
			ShopInfo si = m.getShop();
			si.setsAddr(sAddr);
			si.setsCat(sCat);
			si.setsTel(sTel);
			System.out.println(si.getsStat());
			si.setsStat(si.getsStat());
			m.setShop(si);
			m.setLastModDt(new Date());
			
			try {
				resp.sendRedirect("edit.html");
				return mm.updateMerchant(m);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@RequestMapping(value="deleteMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant deleteMerchant(int mid) {
		try {
			return mm.deleteMerchant(mid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
