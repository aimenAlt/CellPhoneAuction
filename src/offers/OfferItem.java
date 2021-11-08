package offers;

public class OfferItem {
	private int offerID = -1;
	private int lotID = -1;
	private int clientID = -1;
	private double offerPrice = 0.0;
	private String offerStatus = "";
	
	public OfferItem(int offerID, int lotID, int clientID, double offerPrice) {
		this.offerID = offerID;
		this.lotID = lotID;
		this.clientID = clientID;
		this.offerPrice = offerPrice;
		this.offerStatus = "Pending";
	}
	
	public OfferItem(int offerID, int lotID, int clientID, double offerPrice, String offerStatus) {
		this.offerID = offerID;
		this.lotID = lotID;
		this.clientID = clientID;
		this.offerPrice = offerPrice;
		this.offerStatus = offerStatus;
	}
	
	public int getOfferID() {
		return this.offerID;
	}
	
	public int getLotID() {
		return this.lotID;
	}
	
	public double getOfferPrice() {
		return this.offerPrice;
	}
	
	public int getClientID() {
		return this.clientID;
	}
	
	public String offerStatus() {
		return this.offerStatus;
	}
	
	public void setOfferPrice(double newOffer) {
		this.offerPrice = newOffer;
	}
	
	public void setOfferStatus(String newStatus) {
		this.offerStatus = newStatus;
	}
	
	
//	public String[] toStringArr() {
//		String[] arr = {this.offerID, this.lotID, this.clientID, Double.toString(this.offerPrice), this.offerStatus};
//		return arr;
//	}
	
	
}
