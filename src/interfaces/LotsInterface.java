package interfaces;

import java.util.HashMap;

import date.Date;
import lots.LotItem;

public interface LotsInterface {
	
	HashMap<Integer, LotItem> getAllLots();
	LotItem getSingleLot(int LotId);
	LotItem addLot (String lotId, String lotDescription, double askingPrice, Date endDate);
	void deleteLot(String lotId);
	void updateLotPrice(String offerId, double askingPrice);
	void unpublishLot(String lodId);
	void openLot(String lotId);
	void closeLot(String lotId);
	void endLot(String lotId);


}
