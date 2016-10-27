package service;

import java.util.List;

import po.Advertisement;

public interface AdvertisementManager {
	public List<Advertisement> findAllAds();
	public Advertisement findAd(String aid);
	public void insertAd(Advertisement a);
	public void updateAd(Advertisement a);
	public Advertisement getAdvertisementByWebService(String aid);
}
