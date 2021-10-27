package offerItem;

public class OfferItem {
	private int offerId = 0;
	private int lotId = 0;
	private double offerPrice = 0.0;
	private String offerStatus = "";
	
	public OfferItem(int offerId, int lotId, double offerPrice, String offerStatus) {
		this.offerId = offerId;
		this.lotId = lotId;
		this.offerPrice = offerPrice;
		this.offerStatus = offerStatus;
	}
	
	public int getofferId() {
		return this.offerId;
	}
	
	public int getLotId() {
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
