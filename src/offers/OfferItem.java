package offers;

public class OfferItem {
	private String offerID = "";
	private String lotID = "";
	private String clientID = "";
	private double offerPrice = 0.0;
	private String offerStatus = "";
	
	public OfferItem(String offerID, String lotID, String clientID, double offerPrice) {
		this.offerID = offerID;
		this.lotID = lotID;
		this.clientID = clientID;
		this.offerPrice = offerPrice;
		this.offerStatus = "Pending";
	}
	
	public OfferItem(String offerID, String lotID, String clientID, double offerPrice, String offerStatus) {
		this.offerID = offerID;
		this.lotID = lotID;
		this.clientID = clientID;
		this.offerPrice = offerPrice;
		this.offerStatus = offerStatus;
	}
	
	public String getOfferID() {
		return this.offerID;
	}
	
	public String getLotID() {
		return this.lotID;
	}
	
	public double getOfferPrice() {
		return this.offerPrice;
	}
	
	public String getClientID() {
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
	
	
	public String[] toStringArr() {
		String[] arr = {this.offerID, this.lotID, this.clientID, Double.toString(this.offerPrice), this.offerStatus};
		return arr;
	}
	
	
}
