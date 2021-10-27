package offers;

import java.util.HashMap;

public interface OffersInterface {
	
	HashMap<Integer, OfferItem> getAllOffers();
	OfferItem getSingleOffer(int offerId);
	OfferItem addOffer (int offerId, int lotId, double offerPrice);
	void deleteOffer(int offerId);
	void deleteOffersOfLot(int lotId);
	void updateOfferPrice(int offerId, double offerPrice);
	void updateSingleOfferStatus(int offerId, int offerStatus);
	void updateOfferStatusOfLot(int lotId, int offerStatus);
	
	
}
