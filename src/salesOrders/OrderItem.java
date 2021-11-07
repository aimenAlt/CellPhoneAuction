package salesOrders;

import date.Date;
import offers.OfferItem;

public class OrderItem {
	private String orderID = null;
	private String clientID = null;
	private String lotID = null;
	private String offerID = null;
	private String status = null;
	private double purchasePrice = -1;
	private double balance = -1;
	private Date sellDate = null;
	
	//Constructor for when a new instance is created from an offer.
	public OrderItem(String orderID, OfferItem offer, double balance, Date sellDate) {
		this.orderID = orderID;
		this.clientID = offer.getClientID();
		this.lotID = offer.getLotID();
		this.offerID = offer.getOfferID();
		this.purchasePrice = offer.getOfferPrice();
		this.balance = balance;
		this.sellDate = sellDate;
	}
	//Constructor for when instance created from database data.
	public OrderItem(String orderID, String clientID, String lotID, String offerID, double purchasePrice, double balance, Date sellDate) {
		this.orderID = orderID;
		this.clientID = clientID;
		this.lotID = lotID;
		this.offerID = offerID;
		this.purchasePrice = purchasePrice;
		this.balance = balance;
		this.sellDate = sellDate;
	}
	
	public String getOrderID() {
		return this.orderID;
	}
	
	public String getClientID() {
		return this.clientID;
	}
	
	public String getlotID() {
		return this.lotID;
	}
	
	public String getOfferID() {
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
