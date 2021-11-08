package lots;

import java.util.HashMap;

import databaseAccess.LocalDBAccess;

import date.Date;
import interfaces.LotsInterface;

public class Lots implements  LotsInterface{
	
	private HashMap<Integer, LotItem> lots;
//	private String fileAddress = "../tempDatabase/lots_file.txt"; //Local Database variable
//	private LocalDBAccess lotsDB = null; //Local Database variable
	
	public Lots() {
		this.lots = new HashMap<Integer, LotItem>();
//		this.lotsDB = new LocalDBAccess(fileAddress); //Local Database 
//		this.getAllDBLots();
		
	}

	@Override
	public HashMap<Integer, LotItem> getAllLots() {
		return this.lots;
	}

	@Override
	public LotItem getSingleLot(int lotID) {
		return this.lots.get(lotID);
	}

	@Override
	public void deleteLot(int lotID) {
		this.lots.remove(lotID);
	}

	@Override
	public void updateLotPrice(int lotID, double askingPrice) {
		// TODO Auto-generated method stub
		this.lots.get(lotID).setAskingPrice(askingPrice);
	}

	@Override
	public LotItem addLot(int lotID, String lotDescription, double askingPrice, Date endDate) {
		// TODO Auto-generated method stub
		LotItem newLot = new LotItem(lotID, lotDescription, askingPrice, endDate);
		this.lots.put(lotID, newLot);
//		this.lotsDB.addEntry(newLot.toStringArr());
		return newLot;
	}

	@Override
	public void unpublishLot(int lotID) {
		// TODO Auto-generated method stub
		this.lots.get(lotID).setStatus("unpublished");
//		this.updateLocalDB(lotID);
	}

	@Override
	public void openLot(int lotID) {
		// TODO Auto-generated method stub
		this.lots.get(lotID).setStatus("open");
//		this.updateLocalDB(lotID);
		
	}

	@Override
	public void closeLot(int lotID) {
		// TODO Auto-generated method stub
		this.lots.get(lotID).setStatus("closed");
//		this.updateLocalDB(lotID);
		
	}

	@Override
	public void endLot(int lotID) {
		// TODO Auto-generated method stub
//		this.lots.get(lotID).setStatus("ended");
//		this.updateLocalDB(lotID);
	}
	
//	public void getAllDBLots() {
//		HashMap<Integer, String[]> data = this.lotsDB.getDBMap();
//		data.forEach((key, val) -> {
//			this.lots.put(key, new LotItem(val[0], val[1], Double.parseDouble(val[2]), new Date(val[3]), val[4]));
//		});
//	}
	
//	private void updateLocalDB(int lotID) {
//		this.lotsDB.updateEntry(this.lots.get(lotID).toStringArr());
//	}
	
}














