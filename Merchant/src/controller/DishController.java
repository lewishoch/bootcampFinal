package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Dish;
import service.DishManager;
import service.MerchantManager;

@Controller
public class DishController {
	
	@Autowired
	private DishManager dm;
	
	@Autowired
	private MerchantManager mm;

	@RequestMapping(value="findAllOwnDishes", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Dish> findAllOwnDishes(HttpServletRequest request,HttpServletResponse resp) {
		HttpSession s = request.getSession();
		String mid;
		if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
		{
			return dm.findAllOwnDishes(mid);
		}
		return null;
	}
	
	@RequestMapping(value="loadDishById", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Dish loadDish(String did) {
		return dm.loadDish(did);
	}
	
	@RequestMapping(value="loadDishByIdAndName", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Dish loadDishByName(String dname, HttpServletRequest request,HttpServletResponse resp) {
		HttpSession s = request.getSession();
		String mid;
		if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
		{
			return dm.loadDish(mid, dname);	
		}
		return null;
	}
	
	@RequestMapping(value="addDish", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Dish addDish(String dishName, Integer dishPrice, String dishPhoto, String category, HttpServletRequest request,HttpServletResponse resp) {
		HttpSession s = request.getSession();
		String mid;
		if(s != null && (mid = (String)s.getAttribute("uuid")) != null)
		{
			try {
				Dish d = new Dish();
				d.setDishName(dishName);
				d.setDishPrice(dishPrice);
				d.setDishPhoto(dishPhoto);
				d.setMerchant(mm.loadMerchantById(mid));
				d.setCategory(category);
				return dm.addDish(d);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	@RequestMapping(value="deleteDish", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public Dish deleteDish(String did) {
		try {
			return dm.deleteDish(did);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
