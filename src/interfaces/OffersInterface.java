package interfaces;

import java.util.HashMap;

import offers.OfferItem;

public interface OffersInterface {
	
	HashMap<Integer, OfferItem> getAllOffers();
	OfferItem getSingleOffer(String offerId);
	OfferItem addOffer (String offerId, String lotId, double offerPrice);
	void deleteOffer(String offerId);
	void deleteOffersOfLot(String lotId);
	void updateOfferPrice(String offerId, double offerPrice);
	void pendOffer(String offerId);
	void rejectOffer(String offerId);
	void rejectAllLotOffers(String lotId);
	void rejectAllLotOffers(String lotId, String offerId);
	void acceptOffer(String offerId);
	
	
}
