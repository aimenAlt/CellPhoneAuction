package offers;

import java.util.ArrayList;
import java.util.HashMap;

import databaseAccess.LocalDBAccess;
import interfaces.OffersInterface;

public class Offers implements OffersInterface {
	
	private HashMap <String, OfferItem> offers = null;
	private String fileAddress = "../tempDatabase/offers_file.txt";
	private LocalDBAccess localDB = null;
	
	public Offers() {
		this.localDB = new LocalDBAccess(fileAddress);
		this.offers = new HashMap <String, OfferItem>();
		this.getAllDBOffers();
	}

	@Override
	public HashMap<String, OfferItem> getAllOffers() {
		return this.offers;
	}

	@Override
	public OfferItem getSingleOffer(String offerId) {
		return this.offers.get(offerId);
	}

	@Override
	public OfferItem addOffer(String offerId, String lotId, String clientId, double offerPrice) {
		OfferItem newItem = new OfferItem(offerId, lotId, clientId, offerPrice);
		this.localDB.addEntry(newItem.toStringArr());
		this.offers.put(offerId, newItem);
		return newItem;
	}

	@Override
	public void deleteOffer(String offerId) {
		this.offers.remove(offerId);
		this.localDB.deleteEntry(offerId);
	}

	@Override
	public void deleteOffersOfLot(String lotId) {
		this.offers.forEach((key, val) -> {
			if(val.getLotID() == lotId) this.offers.remove(key);
		});
		this.localDB.deleteMultiple(lotId, 1);
	}

	@Override
	public void updateOfferPrice(String offerId, double offerPrice) {
		this.offers.get(offerId).setOfferPrice(offerPrice);
		this.localDB.updateEntry(this.offers.get(offerId).toStringArr());
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
	public ArrayList<OfferItem> getClientOffers(String clientId) {
		ArrayList<OfferItem> list = new ArrayList<OfferItem>();
		this.offers.forEach((key, val) -> { 
			if(val.getClientID() == clientId) list.add(val);
		});
		return list;
	}
	
	public ArrayList<OfferItem> getLotOffers(String lotId) {
		ArrayList<OfferItem> list = new ArrayList<OfferItem>();
		this.offers.forEach((key, val) -> { 
			if(val.getLotID() == lotId) list.add(val);
		});
		return list;
	}
	
	private void getAllDBOffers() {
		HashMap<String, String[]> allData = this.localDB.getDBMap();
		allData.forEach((key, val) -> {
			this.offers.put(key, new OfferItem(val[0], val[1], val[2], Double.parseDouble(val[3]), val[5]));
		});
	}
	
	

}
