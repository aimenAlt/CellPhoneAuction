package interfaces;

import java.util.HashMap;
import java.util.ArrayList;

import offers.OfferItem;

public interface OffersInterface {
	
	HashMap<String, OfferItem> getAllOffers();
	OfferItem getSingleOffer(String offerId);
	ArrayList<OfferItem> getClientOffers(String clientId);
	OfferItem addOffer (String offerId, String lotId, String clientId, double offerPrice);
	void deleteOffer(String offerId);
	void deleteOffersOfLot(String lotId);
	void updateOfferPrice(String offerId, double offerPrice);
	void pendOffer(String offerId);
	void rejectOffer(String offerId);
	void rejectAllLotOffers(String lotId);
	void rejectAllLotOffers(String lotId, String offerId);
	void acceptOffer(String offerId);
	
	
}
