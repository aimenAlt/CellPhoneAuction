package salesOrders;

import date.Date;
//import offers.OfferItem;

public class OrderItem {
	private int orderID = -1;
	private int clientID = -1;
	private int lotID = -1;
	private int offerID = -1;
	private String status = null;
	private double purchasePrice = -1;
	private double balance = -1;
	private Date sellDate = null;
	
	//Constructor for when a new instance is created from an offer.
//	public OrderItem(int orderID, OfferItem offer, double balance, Date sellDate) {
//		this.orderID = orderID;
//		this.clientID = offer.getClientID();
//		this.lotID = offer.getLotID();
//		this.offerID = offer.getOfferID();
//		this.purchasePrice = offer.getOfferPrice();
//		this.balance = balance;
//		this.sellDate = sellDate;
//	}
	//Constructor for when instance created from database data.
	public OrderItem(int orderID, int clientID, int lotID, int offerID, String status, double purchasePrice, double balance, Date sellDate) {
		this.orderID = orderID;
		this.clientID = clientID;
		this.lotID = lotID;
		this.offerID = offerID;
		this.status = status;
		this.purchasePrice = purchasePrice;
		this.balance = balance;
		this.sellDate = sellDate;
	}
	
	public int getOrderID() {
		return this.orderID;
	}
	
	public int getClientID() {
		return this.clientID;
	}
	
	public int getlotID() {
		return this.lotID;
	}
	
	public int getOfferID() {
		return this.offerID;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public double getPurchasePrice() {
		return this.purchasePrice;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public Date getSellDate() {
		return this.sellDate;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
