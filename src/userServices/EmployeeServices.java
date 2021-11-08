package userServices;

import java.util.HashMap;

import databaseTables.LotsTable;
import databaseTables.OffersTable;
import databaseTables.SalesOrdersTable;
import date.Date;
import exceptions.ApplicationException;
import lots.LotItem;
import lots.Lots;
import offers.OfferItem;
import offers.Offers;
import salesOrders.SalesOrders;
import user.UserItem;

public class EmployeeServices {
	
	private UserItem user = null;
//	private Offers offers = null;
	private Lots lots = null;
	private SalesOrders orders = null;

//	private void refreshOffers() throws ApplicationException {
//		this.offers = new Offers(OffersTable.offersOfLot());
//	}
	
	private void refreshLots() throws ApplicationException {
		this.lots = new Lots(LotsTable.getAllLots());
	}
	private void refreshOrders() throws ApplicationException {
		this.orders = new SalesOrders(SalesOrdersTable.getAllOrders());
	}
	
	//Get offers of lot
	public HashMap<Integer, OfferItem> offersOfLot(int lotID) throws ApplicationException {
		HashMap<Integer, OfferItem> offers = null;
		offers = OffersTable.offersOfLot(lotID);
		return offers;
	}
	//accept offer
		//when accepting offer, change all offersOfLot to rejected
		//new sale order created
	public void acceptOffer(OfferItem offer, LotItem lot, Date dateToday) throws ApplicationException {
		offer.setOfferStatus("accepted");
		lot.setStatus("closed");
		OffersTable.updateLotOffers(offer.getLotID(), "rejected");
		OffersTable.updateOffer(offer);
		LotsTable.updateLot(lot);
		SalesOrdersTable.addOrder(offer, "unpaid", dateToday);
		
		this.refreshLots();
		this.refreshOrders();
	}
	//reject offer
	public void rejectOffer(OfferItem offer) throws ApplicationException {
		offer.setOfferStatus("rejected");
		OffersTable.updateOffer(offer);

	}
	//get all lots
	public Lots getLots() {
		return this.lots;
	}
	//get all orders
		//for manager
	
	//Add new lot
	public void addLot(String description, double askingPrice, Date endDate) throws ApplicationException {
		LotsTable.addLot(description, askingPrice, endDate, "unpublished");
		this.refreshLots();
	}
	//open lot
	public void openLot(LotItem lot) throws ApplicationException {
		lot.setStatus("open");
		LotsTable.updateLot(lot);
		this.refreshLots();
	}
	//close lot - time ended or an offer was accepted
		//reject all offers
	public void closeLot(LotItem lot) throws ApplicationException {
		lot.setStatus("closed");
		LotsTable.updateLot(lot);
		OffersTable.updateLotOffers(lot.getLotID(), "rejected");
		this.refreshLots();
	}
	//cancel lot - cancelled midway no winners
		//reject all offers
	public void cancelLot(LotItem lot) throws ApplicationException {
		lot.setStatus("cancelled");
		LotsTable.updateLot(lot);
		OffersTable.updateLotOffers(lot.getLotID(), "rejected");
		this.refreshLots();
	}

	//change price of lot
	public void changeAskingPrice(LotItem lot, double newPrice) throws ApplicationException {
		lot.setAskingPrice(newPrice);
		LotsTable.updateLot(lot);
		OffersTable.updateLotOffers(lot.getLotID(), "rejected");
		this.refreshLots();
	}

	//change description of lot
	public void changeDescription(LotItem lot, String newDesc) throws ApplicationException {
		lot.setDescription(newDesc);
		LotsTable.updateLot(lot);
		OffersTable.updateLotOffers(lot.getLotID(), "rejected");
		this.refreshLots();
	}
	

}
