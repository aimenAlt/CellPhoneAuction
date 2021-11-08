package interfaces;

import java.util.HashMap;

import date.Date;
import lots.LotItem;

public interface LotsInterface {
	
	HashMap<Integer, LotItem> getAllLots();
	LotItem getSingleLot(int lotID);
	LotItem addLot (int lotID, String lotDescription, double askingPrice, Date endDate);
	void deleteLot(int lotID);
	void updateLotPrice(int lotID, double askingPrice);
	void unpublishLot(int lotID);
	void openLot(int lotID);
	void closeLot(int lotID);
	void endLot(int lotID);


}
