package offers;

import java.util.ArrayList;
import java.util.HashMap;

import interfaces.OffersInterface;

public class Offers implements OffersInterface {

	@Override
	public HashMap<Integer, OfferItem> getAllOffers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfferItem getSingleOffer(String offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfferItem addOffer(String offerId, String lotId, double offerPrice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOffer(String offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOffersOfLot(String lotId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOfferPrice(String offerId, double offerPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pendOffer(String offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectOffer(String offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectAllLotOffers(String lotId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectAllLotOffers(String lotId, String offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptOffer(String offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<OfferItem> getCustomerOffers(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
