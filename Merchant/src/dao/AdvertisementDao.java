package dao;

import java.util.List;

import po.Advertisement;

public interface AdvertisementDao {
	public List<Advertisement> findAllOwnAdvertisements(String mid);
	public Advertisement addAdvertisement(Advertisement a);
}
