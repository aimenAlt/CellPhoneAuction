package userServices;

import exceptions.ApplicationException;
import lots.Lots;
import offers.OfferItem;
import offers.Offers;
import salesOrders.OrderItem;
import salesOrders.SalesOrders;
import user.UserItem;
import databaseTables.LotsTable;
import databaseTables.OffersTable;
import databaseTables.SalesOrdersTable;

public class ClientServices {

	private UserItem user = null;
	private Offers offers = null;
	private Lots lots = null;
	private SalesOrders orders = null;
	
	private void refreshOffers() throws ApplicationException {
		this.offers = new Offers(OffersTable.offersOfUser(this.user.getUserID()));
	}
	private void refreshLots() throws ApplicationException {
		this.lots = new Lots(LotsTable.openLots());
	}
	private void refreshOrders() throws ApplicationException {
		this.orders = new SalesOrders(SalesOrdersTable.ordersOfUser(this.user.getUserID()));
	}
	
	public ClientServices (UserItem user) throws ApplicationException {
		this.user = user;
		this.refreshOffers();
		this.refreshLots();
		this.refreshOrders();

	}
	
	//Get Lots
	public Lots getAvailableLots() {
		return this.lots;
	}
	//Show Offers
	public Offers getClientOffers() {
		return this.offers;
	}
	
	//show sales orders
	public SalesOrders getClientOrders() {
		return this.orders;
	}
	//make new offer
	public void newOffer(int lotID, int clientID, double offerPrice) throws ApplicationException {
		int id = OffersTable.addOffer(lotID, clientID, offerPrice, "unpublished");
		this.refreshOffers();
	}
	//withdraw offer
	public void withdrawOffer(int offerID) {
		OfferItem tempOffer = this.offers.getOffer(offerID);
	}
	//make payment on sales order
	public double pay(int orderID, double amount) throws ApplicationException {
		double remaining = -1;
		OrderItem tempOrder = this.orders.getOrder(orderID);
		if(amount < 0) {
			System.out.println("We can't pay you!");
		} else if (amount > tempOrder.getBalance()) {
			System.out.println("No Tipping Allowed!");
		} else {
			remaining = tempOrder.getBalance() - amount;
			tempOrder.setBalance(remaining);
			SalesOrdersTable.updateOrder(tempOrder);
			this.refreshOrders();
		}
		return remaining;
	}
	//generate sales order file
	
	//remove offer
	
	
	
}
