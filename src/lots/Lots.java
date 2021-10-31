package lots;

import java.util.HashMap;

import databaseAccess.DatabaseAccess;

import date.Date;
import interfaces.LotsInterface;

public class Lots implements  LotsInterface{
	
	private HashMap<String, LotItem> lots;
	private String fileAddress = "../tempDatabase/lots_file.txt"; //Local Database variable
	private DatabaseAccess lotsDB = null; //Local Database variable
	
	public Lots() {
		this.lots = new HashMap<String, LotItem>();
		this.lotsDB = new DatabaseAccess(fileAddress); //Local Database 
		this.getAllDBLots();
		
	}

	@Override
	public HashMap<String, LotItem> getAllLots() {
		return this.lots;
	}

	@Override
	public LotItem getSingleLot(String lotId) {
		return this.lots.get(lotId);
	}

	@Override
	public void deleteLot(String lotId) {
		this.lots.remove(lotId);
	}

	@Override
	public void updateLotPrice(String lotId, double askingPrice) {
		// TODO Auto-generated method stub
		this.lots.get(lotId).setAskingPrice(askingPrice);
	}

	@Override
	public LotItem addLot(String lotId, String lotDescription, double askingPrice, Date endDate) {
		// TODO Auto-generated method stub
		LotItem newLot = new LotItem(lotId, lotDescription, askingPrice, endDate);
		this.lots.put(lotId, newLot);
		return null;
	}

	@Override
	public void unpublishLot(String lotId) {
		// TODO Auto-generated method stub
		this.lots.get(lotId).setStatus("unpublished");
	}

	@Override
	public void openLot(String lotId) {
		// TODO Auto-generated method stub
		this.lots.get(lotId).setStatus("open");
		
	}

	@Override
	public void closeLot(String lotId) {
		// TODO Auto-generated method stub
		this.lots.get(lotId).setStatus("closed");

		
	}

	@Override
	public void endLot(String lotId) {
		// TODO Auto-generated method stub
		this.lots.get(lotId).setStatus("ended");
		
	}
	
	public void getAllDBLots() {
		HashMap<String, String[]> data = this.lotsDB.getDBMap();
		data.forEach((key, val) -> {
			this.lots.put(key, new LotItem(val[0], val[1], Double.parseDouble(val[2]), new Date(val[3]), val[4]));
		});
	}
	
}














