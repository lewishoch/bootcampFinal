package service;

import java.util.List;

import po.Advertisement;

public interface AdvertisementManager {
	public List<Advertisement> findAllOwnAdvertisements(String mid);
	public Advertisement addAdvertisement(Advertisement a);
}
