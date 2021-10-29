package lots;

import java.util.HashMap;

import date.Date;
import interfaces.LotsInterface;

public class Lots implements  LotsInterface{
	
	private HashMap<Integer, LotItem> lots;
	
	public Lots() {
		this.lots = new HashMap<Integer, LotItem>();
	}

	@Override
	public HashMap<Integer, LotItem> getAllLots() {
		// TODO Auto-generated method stub
		return this.lots;
	}

	@Override
	public LotItem getSingleLot(int lotId) {
		// TODO Auto-generated method stub
		return this.lots.get(lotId);
	}

	@Override
	public void deleteLot(String lotId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLotPrice(String lotId, double askingPrice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LotItem addLot(String lotId, String lotDescription, double askingPrice, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unpublishLot(String lodId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openLot(String lotId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeLot(String lotId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endLot(String lotId) {
		// TODO Auto-generated method stub
		
	}
	
}
