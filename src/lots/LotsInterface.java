package lots;

import java.util.HashMap;

//import offers.OfferItem;

public interface LotsInterface {
	
	HashMap<Integer, LotItem> getAllLots();
	LotItem getSingleLot(int LotId);
	LotItem addLot (int lotId, double askingPrice);
	void deleteLot(int lotId);
	void updateLotPrice(int offerId, double askingPrice);
	void updateLotStatus(int lotId, int lotStatus);


}
