package dao;

import java.util.List;

import po.Advertisement;

public interface AdvertisementDao {
	public Advertisement loadAd(String aid);
	public List<Advertisement> loadAllAds();
	public List<Advertisement> loadAdsByStatus(String status);
	public void insertAd(Advertisement a);
	public void updateAd(Advertisement a);
}
