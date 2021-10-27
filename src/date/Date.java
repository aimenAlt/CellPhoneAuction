package date;

public class Date {
	private int month = 0;
	private int day = 0;
	private int year = 0;
	
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}
}
