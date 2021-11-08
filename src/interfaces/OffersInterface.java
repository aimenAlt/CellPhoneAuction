package interfaces;

import java.util.HashMap;
import java.util.ArrayList;

import offers.OfferItem;

public interface OffersInterface {
	
	HashMap<Integer, OfferItem> getAllOffers();
	OfferItem getOffer(int offerID);
	ArrayList<OfferItem> getClientOffers(int clientID);
	OfferItem addOffer (int offerID, int lotId, int clientID, double offerPrice);
	void deleteOffer(int offerID);
	void deleteOffersOfLot(int lotId);
	void updateOfferPrice(int offerID, double offerPrice);
	void pendOffer(int offerID);
	void rejectOffer(int offerID);
	void rejectAllLotOffers(int lotId);
	void rejectAllLotOffers(int lotId, int offerID);
	void acceptOffer(int offerID);
	
	
}
