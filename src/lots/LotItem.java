package lots;

import date.Date;

public class LotItem {
	private int lotID = -1;
	private String description = "";
	private double askingPrice = 0.0;
	private Date endDate;
	private String lotStatus = "";
	
	public LotItem(int lotID, String description, double askingPrice,
				   Date endDate) {
		this.lotID = lotID;
		this.description = description;
		this.askingPrice = askingPrice;
		this.endDate = endDate;
		this.lotStatus = "unpublished";
	}
	
	public LotItem(int lotID, String description, double askingPrice,
			   Date endDate, String lotStatus) {
	this.lotID = lotID;
	this.description = description;
	this.askingPrice = askingPrice;
	this.endDate = endDate;
	this.lotStatus = lotStatus;
}
	public int getLotID() {
		return this.lotID;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public double getAskingPrice() {
		return this.askingPrice;
	}
	
	public String getEndDate() {
		return this.endDate.toString();
	}
	
	public String getStatus() {
		return this.lotStatus;
	}
	//Set
	public String setDescription(String newDesc) {
		this.description = newDesc;
		return this.description;
	}
	
	public double setAskingPrice(double newPrice) {
		this.askingPrice = newPrice;
		return this.askingPrice;
	}
	
	public String setEndDate(Date newDate) {
		this.endDate = newDate;
		return this.endDate.toString();
	}
	
	public String setStatus(String newStatus) {
		this.lotStatus = newStatus;
		return this.lotStatus;
	}
	
//	public String[] toStringArr() {
//		String[] arr = {this.lotID, this.description, Double.toString(this.askingPrice), this.endDate.toString(), this.lotStatus};
//		return arr;
//	}

	
}
