package userServices;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import databaseTables.LotsTable;
import databaseTables.OffersTable;
import databaseTables.SalesOrdersTable;
import date.Date;
import exceptions.ApplicationException;
import lots.LotItem;
import lots.Lots;
import offers.OfferItem;
import salesOrders.SalesOrders;
import user.UserItem;

public class EmployeeServices {
	
	private static final Logger logger = LogManager.getLogger(EmployeeServices.class);
	
	private UserItem user = null;
	private Lots lots = null;
	protected SalesOrders orders = null;

	private void refreshLots() throws ApplicationException {
		this.lots = new Lots(LotsTable.getAllLots());
	}
	protected void refreshOrders() throws ApplicationException {
		this.orders = new SalesOrders(SalesOrdersTable.getAllOrders());
	}
	
	public EmployeeServices(UserItem user) throws ApplicationException {
		this.user = user;
		this.refreshLots();
		this.refreshOrders();
	}
	
	//Get offers of lot
	public HashMap<Integer, OfferItem> offersOfLot(int lotID) throws ApplicationException {
		logger.info("Entered offersOfLot in ExmployeeServices.");
		HashMap<Integer, OfferItem> offers = null;
		offers = OffersTable.offersOfLot(lotID);
		logger.info("Exiting offersOfLot in ExmployeeServices.");
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
		logger.info("Entered rejectOffer() in services");
		offer.setOfferStatus("rejected");
		OffersTable.updateOffer(offer);
		logger.info("exiting rejectOffer() in services");

	}
	//get all lots
	public HashMap<Integer, LotItem> getLots() {
		return this.lots.getAllLots();
	}
	
	//Add new lot
	public void addLot(String description, double askingPrice, Date endDate) throws ApplicationException {
		logger.info("Entered addLot() in services");
		LotsTable.addLot(description, askingPrice, endDate, "unpublished");
		this.refreshLots();
		logger.info("Exited addLot() in services");
	}
	//open lot
	public void openLot(LotItem lot) throws ApplicationException {
		logger.info("Entered openLot() in services");
		lot.setStatus("open");
		LotsTable.updateLot(lot);
		this.refreshLots();
		logger.info("Exited openLot() in services");

	}
	//close lot - time ended or an offer was accepted
		//reject all offers
	public void closeLot(LotItem lot) throws ApplicationException {
		logger.info("Entered closeLot() in services");
		lot.setStatus("closed");
		LotsTable.updateLot(lot);
		OffersTable.updateLotOffers(lot.getLotID(), "rejected");
		this.refreshLots();
		logger.info("Exiting closeLot() in services");

	}
	//cancel lot - cancelled midway no winners
		//reject all offers
	public void cancelLot(LotItem lot) throws ApplicationException {
		logger.info("Entered cancelLot() in services");
		lot.setStatus("cancelled");
		LotsTable.updateLot(lot);
		OffersTable.updateLotOffers(lot.getLotID(), "rejected");
		this.refreshLots();
		logger.info("Exiting cancelLot() in services");

	}

	//change price of lot
	public void changeAskingPrice(LotItem lot, double newPrice) throws ApplicationException {
		logger.info("Entered changeAskingPrice() in services");
		lot.setAskingPrice(newPrice);
		LotsTable.updateLot(lot);
		this.refreshLots();
		logger.info("Exiting changeAskingPrice() in services");

	}

	//change description of lot
	public void changeDescription(LotItem lot, String newDesc) throws ApplicationException {
		logger.info("Entered changeDescription() in services");
		lot.setDescription(newDesc);
		LotsTable.updateLot(lot);
		this.refreshLots();
		logger.info("Exiting changeDescription() in services");
	}
	

}
