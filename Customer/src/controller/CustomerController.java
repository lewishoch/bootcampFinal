package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Advertisement;
import po.Customer;
import po.Dish;
import po.Merchant;
import po.Order;
import po.OrderedDish;
import service.AdvertisementManager;
import service.CustomerManager;
import service.MerchantManager;
import service.OrderManager;
import service.OrderedDishManager;
import service.ShopInfoManager;
import service.impl.DishManagerImpl;
import vo.Adv;
import vo.AllDishOfMerchant;
import vo.AllShop;
import vo.Cart;
import vo.CartDish;
import vo.CartPageInfo;
import vo.ShopInfo;

@Controller
public class CustomerController {

	@Autowired
	private AdvertisementManager am;
	@Autowired
	private CustomerManager cm;
	@Autowired
	private MerchantManager mm;
	@Autowired
	private OrderManager om;
	@Autowired
	private ShopInfoManager sm;
	@Autowired
	private DishManagerImpl dm;
	@Autowired
	private OrderedDishManager odm;
	
	@RequestMapping(value="/login", method={RequestMethod.POST})
	@ResponseBody
	public Customer login(String uname, String psd, HttpServletRequest request,HttpServletResponse resp) throws IOException{
		System.out.println("login controller --> " + uname + ":" + psd );
		HttpSession sen = request.getSession(true);
		
		Customer c = cm.loadCustomerByName(uname);
		
		if(c == null)
		{
			System.out.println("login invalid");
			resp.sendRedirect("index.html");
			return null;
		}
		
		if(c != null && c.getPsd().equals(psd))
		{
			System.out.println("login valid");
			
			sen.setAttribute("isLogin", true);
			sen.setAttribute("uuid", c.getCid());
			
			System.out.println("Login success");
			
			resp.sendRedirect("shop.html");
			return c;
		}
		resp.sendRedirect("index.html");
		return null;
	}
	
	@RequestMapping(value="/signup", method={RequestMethod.POST})
	@ResponseBody
	public Customer signup(String uname, String psd, String tel, String[] addr,HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		System.out.println("signup controller --> "+uname + ":" + psd );
		
		HttpSession sen = req.getSession(true);
		
		List<String> address = new ArrayList<String>(); 
		for(int i=0;i<addr.length;i++)
		{
			address.add(addr[i]);
		}
	
		Customer c = cm.loadCustomerByName(uname);
		
		if(c == null)
		{
			
			System.out.println("no existing user: valid");
			// no existing user
			Customer newC = new Customer();
			newC.setAddress(address);
			newC.setCreDt(new Date());
			newC.setLastModDt(new Date());
			newC.setName(uname);
			newC.setPsd(psd);
			
			cm.addCustomer(newC);
			
			sen.setAttribute("isLogin", true);
			sen.setAttribute("uuid", newC.getCid());
			
			resp.sendRedirect("shop.html");
			return newC;
		}
		else
		{
			System.out.println("have existing user: invalid");
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
	
	
	@RequestMapping(value="addCustomer", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Customer addCustomer(Customer c){
		System.out.println("adding customer...");
		return cm.addCustomer(c);
	}
	
	@RequestMapping(value="loadCustomer", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Customer loadCustomer(String id){
		System.out.println("loading customer...");
		return cm.loadCustomer(id);
	}
	
	@RequestMapping(value="updateCustomer", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Customer updatCustomer(Customer c){
		System.out.println("updating customer...");
		return cm.updateCustomer(c);
	}
	
	@RequestMapping(value="findMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Merchant findMerchant(String id){
		System.out.println("finding a merchant...");
		return mm.findMerchant(id);
	}

	@RequestMapping(value="findAllMerchant", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Merchant> findAllMerchant(){
		System.out.println("finding all merchants...");
		return mm.findAllMerchant();
	}
	
	@RequestMapping(value="findOrder", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Order findOrder(String id){
		System.out.println("finding an order...");
		return om.findOrder(id);
	}
	
	@RequestMapping(value="viewAllOrders", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody	
	public List<Order> viewAllOrders(HttpServletRequest request){
		System.out.println("displaying all orders...");
		return om.viewAllOrder(request);
	}
	
//	@RequestMapping(value="cart", method={RequestMethod.GET, RequestMethod.POST})
//	@ResponseBody	
//	public List<Cart> cart (Order order, String mid, CartDish cd){
//		
//		
//	}
	
	@RequestMapping(value="updateOrder", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Order updateOrder(Order order){
		System.out.println("updating an order...status/comment/rating");
		return om.updateOrder(order);
	}	
	
	@RequestMapping(value="sendComment", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Order sendComment(String oid,String content, String rating){
		System.out.println("sendComment");
		
		Order o = om.findOrder(oid);
		o.setComments(content);
		o.setRating(Integer.parseInt(rating));
		
		
		return null;
		
	}	
	
	
	@RequestMapping(value="findAllShop", method={RequestMethod.GET})
	@ResponseBody
	public List<AllShop> findAllShop(){
		//name, tel, addr, picPath, rating, mid, cat (list of object) 

		System.out.println("findAllShop controller");
		
		List<AllShop> m = mm.findAllShop();
		
		
		return m;
		
	}
	
	@RequestMapping(value="findAllAdv", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Adv> findAdv(){
		System.out.println("findAdv controller");
		List<Adv> advs = new ArrayList<Adv>();
		
		List<Advertisement> Advertisements = am.findlastestAdv(3);
		for(Advertisement a: Advertisements)
		{
			Adv adv = new Adv();
			adv.setMid(a.getMerchant().getMid());
			adv.setShopLogoName(a.getMerchant().getShop().getsLogoPath());
			advs.add(adv);			
		}
	
		return advs;
		
	}
	
	@RequestMapping(value="loadShopInfo", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Merchant> loadShopInfo(String mid, String category){
	System.out.println("loading shop information....");
	return sm.loadShopInfo(mid, category);
	}

	@RequestMapping(value="loadAllDish", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AllDishOfMerchant findAllDishes(String mid, HttpServletRequest request,HttpServletResponse resp){
		//cart(mid, dish:[did + number]), dish(did,picPath,name,cat,price), comment(uname, date, content), merchant(mid, name)
		System.out.println("finding all dishes....");
		
		Merchant m = mm.findMerchant(mid);
		
		AllDishOfMerchant obj = new AllDishOfMerchant();
		obj.setDish(sm.loadAllDishOfMerchant(mid));
		obj.setComment(sm.loadAllCommmentsOfMerchant(mid));
		
		vo.Merchant mObj = new vo.Merchant();
		mObj.setMid(m.getMid());
		mObj.setName(m.getmName());
		obj.setMerchant(mObj);
		
		HttpSession s = request.getSession();
		if(s != null && s.getAttribute(mid) != null)
		{
			System.out.println("!!!!!!!!!!!!!!!!!session has cart obj");
			obj.setCart((Cart)s.getAttribute(mid));
		}
		else
		{
			System.out.println("session no cart obj");
			
			Cart cc = new Cart();
			List<CartDish> cd = new ArrayList<CartDish>();
			cc.setCartDish(cd);
			obj.setCart(cc);
		}
		return obj;
	}

	@RequestMapping(value="findAllComments", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Order> findAllComments(String mid){
	System.out.println("finding all comments....");
	return sm.findAllComments(mid);
	}

	@RequestMapping(value="findDishesByCategory", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Dish> findDishesByCategory(String category){
	System.out.println("finding all dishes by category....");
	return sm.findDishesByCategory(category);
	}
	
	@RequestMapping(value="addToCart", method={RequestMethod.GET, RequestMethod.POST}, headers = {"Content-type=application/json"})
	@ResponseBody
	public void addToCart(@RequestBody Cart cart, HttpServletRequest request,HttpServletResponse resp){
		
		HttpSession s = request.getSession();
		System.out.println("-->" + cart.getMid());
		if(s != null)
		{
			System.out.println("addToCart controller");
			s.setAttribute(cart.getMid(), cart);
			System.out.println("set cart session for "+cart.getMid()+"success");
		}
	}
	
	
	// ajax get shop, all dish, cart
	@RequestMapping(value="findForCart", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public CartPageInfo findForCart(String mid, HttpServletRequest request,HttpServletResponse resp){
		
		System.out.println("findForCart controller");
		
		Merchant m = mm.findMerchant(mid);
		po.ShopInfo shopInfo = m.getShop();
		vo.ShopInfo voShop = new vo.ShopInfo();
		voShop.setsAddr(shopInfo.getsAddr());
		voShop.setsCat(shopInfo.getsCat());
		voShop.setsName(shopInfo.getsName());
		voShop.setsStat(shopInfo.getsStat());

		CartPageInfo CartPageInfo = new CartPageInfo();
		CartPageInfo.setShopInfo(voShop);
		CartPageInfo.setDish(sm.loadAllDishOfMerchant(mid));
		
		HttpSession s = request.getSession();
		if(s != null && s.getAttribute(mid) != null)
		{
			System.out.println("session has cart obj");
			CartPageInfo.setCart((Cart)s.getAttribute(mid));
		}
//		else
//		{
//			System.out.println("session no cart obj");
//			
//			Cart cc = new Cart();
//			List<CartDish> cd = new ArrayList<CartDish>();
//			cc.setCartDish(cd);
//			CartPageInfo.setCart(cc);
//		}
		return CartPageInfo;
	}
	
	@RequestMapping(value="submitOrder", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public void addToCart(String mid, HttpServletRequest request,HttpServletResponse resp) throws IOException{
		
		HttpSession s = request.getSession();
		Cart c = (Cart)s.getAttribute(mid);
	
		
		
		Order o = new Order();
		o.setCreDt(new Date());
		o.setLastModDt(new Date());
		o.setComments("");
		o.setRating(0);
		o.setStatus(1);
		
		Merchant m = mm.findMerchant(mid);
		o.setMerchant(m);
		Customer customer = cm.loadCustomer((String)s.getAttribute("uuid"));
		o.setCustomer(customer);
		
		for(int i = 0 ; i < c.getCartDish().size(); i++)
		{
			OrderedDish odh = new OrderedDish();
			String did = c.getCartDish().get(i).getDid();
			String number = c.getCartDish().get(i).getNumber();
			odh.setDish(dm.getDish(did));
			odh.setQuantity(Integer.parseInt(number));
			o.getDishes().add(odh);
			odm.createOrderedDish(odh);
		}
		om.createOrder(o);
		
		
//		resp.sendRedirect("shop.html");
//		o.getDishes()
//		
		
	}
	

}
