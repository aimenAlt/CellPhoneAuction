package offers;

import java.util.ArrayList;
import java.util.HashMap;

//import databaseAccess.LocalDBAccess;
import interfaces.OffersInterface;

public class Offers implements OffersInterface {
	
	private HashMap <Integer, OfferItem> offers = null;
//	private String fileAddress = "../tempDatabase/offers_file.txt";
//	private LocalDBAccess localDB = null;
	
	public Offers() {
//		this.localDB = new LocalDBAccess(fileAddress);
		this.offers = new HashMap <Integer, OfferItem>();
//		this.getAllDBOffers();
	}

	@Override
	public HashMap<Integer, OfferItem> getAllOffers() {
		return this.offers;
	}

	@Override
	public OfferItem getSingleOffer(int offerId) {
		return this.offers.get(offerId);
	}

	@Override
	public OfferItem addOffer(int offerId, int lotId, int clientId, double offerPrice) {
		OfferItem newItem = new OfferItem(offerId, lotId, clientId, offerPrice);
//		this.localDB.addEntry(newItem.toStringArr());
//		this.offers.put(offerId, newItem);
		return newItem;
	}

	@Override
	public void deleteOffer(int offerId) {
		this.offers.remove(offerId);
//		this.localDB.deleteEntry(offerId);
	}

	@Override
	public void deleteOffersOfLot(int lotId) {
		this.offers.forEach((key, val) -> {
			if(val.getLotID() == lotId) this.offers.remove(key);
		});
//		this.localDB.deleteMultiple(lotId, 1);
	}

	@Override
	public void updateOfferPrice(int offerId, double offerPrice) {
		this.offers.get(offerId).setOfferPrice(offerPrice);
//		this.localDB.updateEntry(this.offers.get(offerId).toStringArr());
	}

	@Override
	public void pendOffer(int offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectOffer(int offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectAllLotOffers(int lotId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rejectAllLotOffers(int lotId, int offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptOffer(int offerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<OfferItem> getClientOffers(int clientId) {
		ArrayList<OfferItem> list = new ArrayList<OfferItem>();
		this.offers.forEach((key, val) -> { 
			if(val.getClientID() == clientId) list.add(val);
		});
		return list;
	}
	
	public ArrayList<OfferItem> getLotOffers(int lotId) {
		ArrayList<OfferItem> list = new ArrayList<OfferItem>();
		this.offers.forEach((key, val) -> { 
			if(val.getLotID() == lotId) list.add(val);
		});
		return list;
	}
	
//	private void getAllDBOffers() {
//		HashMap<Integer, String[]> allData = this.localDB.getDBMap();
//		allData.forEach((key, val) -> {
//			this.offers.put(key, new OfferItem(val[0], val[1], val[2], Double.parseDouble(val[3]), val[5]));
//		});
//	}
	
	

}
