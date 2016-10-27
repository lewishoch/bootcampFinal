package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ShopInfoDao;
import po.Dish;
import po.Merchant;
import po.Order;
import service.ShopInfoManager;
import vo.AllDishOfMerchant;
import vo.Comment;

@Service
public class ShopInfoManagerImpl implements ShopInfoManager {

	@Autowired
	private ShopInfoDao sd;
	
	@Override
	public List<Dish> findAllDishes(String mid) {
		return sd.findAllOwnDishes(mid);
	}

	@Override
	public List<Order> findAllComments(String mid) {
		return sd.findAllComments(mid);
	}

	@Override
	public List<Dish> findDishesByCategory(String category) {
		return sd.findDishesByCategory(category);
	}

	@Override
	public List<Merchant> loadShopInfo(String mid, String category) {
		return sd.loadShopInfo(mid, category);
	}
	
	@Override
	public Set<vo.Dish> loadAllDishOfMerchant(String mid) {
		
	
		// dish
		List<po.Dish> pdish = findAllDishes(mid);
		
		Set<vo.Dish> vdish = new HashSet<vo.Dish>();
		for(po.Dish d: pdish)
		{	
			vo.Dish vd = new vo.Dish();
			vd.setCat(d.getCategory());
			vd.setDid(d.getDid());
			vd.setName(d.getDishName());
			vd.setPicPath(d.getDishPhoto());
			vd.setPrice(d.getDishPrice());
			
			vdish.add(vd);	
		}
		return vdish;
		
	}
	
	@Override
	public List<vo.Comment> loadAllCommmentsOfMerchant(String mid) {
		
	
		// dish
		List<Order> orders = findAllComments(mid);
		
		List<vo.Comment> comments = new ArrayList<vo.Comment>();
		for(Order o: orders)
		{
			Comment c = new Comment();
			c.setContent(o.getComments());
			c.setUname(o.getCustomer().getName());
			
			comments.add(c);
		}
		return comments;
	}
	
	

}
