package dao;

import java.util.List;

import po.Advertisement;

public interface AdvertisementDao {
	public List<Advertisement> findlastestAdv(int num);
}
