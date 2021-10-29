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
	
	public Date(String date) {
		String[] dateArr = date.split("/");
		this.month = Integer.parseInt(dateArr[0]);
		this.day = Integer.parseInt(dateArr[1]);
		this.year = Integer.parseInt(dateArr[2]);
	}
	@Override
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}
}
