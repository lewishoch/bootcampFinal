package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import po.Dish;
import service.DishManager;

@Controller
@RequestMapping(value="dish")
public class DishController {
	
	@Autowired
	private DishManager dm;

	@RequestMapping(value="findAllOwnDishes")
	@ResponseBody
	public List<Dish> findAllOwnDishes(String mid) {
		return dm.findAllOwnDishes(mid);
	}
	
	@RequestMapping(value="loadDishById")
	@ResponseBody
	public Dish loadDish(String did) {
		return dm.loadDish(did);
	}
	
	@RequestMapping(value="loadDishByIdAndName")
	@ResponseBody
	public Dish loadDish(String mid, String dname) {
		return dm.loadDish(mid, dname);
	}
	
	@RequestMapping(value="addDish",method={RequestMethod.POST})
	@ResponseBody
	public String addDish(Dish d) {
		try {
			dm.addDish(d);
			return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"status\":0}";
		}
	}
	
	@RequestMapping(value="deleteDish",method={RequestMethod.POST})
	@ResponseBody
	public String deleteDish(String did) {
		try {
			dm.deleteDish(did);
			return "{\"status\":1}";
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"status\":0}";
		}
	}
	
}
