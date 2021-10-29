package offers;

public class OfferItem {
	private String offerId = "";
	private String lotId = "";
	private double offerPrice = 0.0;
	private String offerStatus = "";
	
	public OfferItem(String offerId, String lotId, double offerPrice) {
		this.offerId = offerId;
		this.lotId = lotId;
		this.offerPrice = offerPrice;
		this.offerStatus = "Pending";
	}
	
	public String getofferId() {
		return this.offerId;
	}
	
	public String getLotId() {
		return this.lotId;
	}
	
	public double getOfferPrice() {
		return this.offerPrice;
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
	
}
