package lots;

import date.Date;

public class LotItem {
	private String lotId = "";
	private String description = "";
	private double askingPrice = 0.0;
	private Date endDate;
	private String lotStatus = "";
	
	public LotItem(String lotId, String description, double askingPrice,
				   Date endDate, String lotStatus) {
		this.lotId = lotId;
		this.description = description;
		this.askingPrice = askingPrice;
		this.endDate = endDate;
		this.lotStatus = lotStatus;
	}
	//Get
	public String getLotId() {
		return this.lotId;
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
	
}
