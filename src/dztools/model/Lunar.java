package dztools.model;

public class Lunar {
	private int year;
	private int month;
	private int day;
	private boolean leap;
	private String displyDate;
	private String solarDate;
	private boolean isToday;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public boolean isLeap() {
		return leap;
	}
	public void setLeap(boolean leap) {
		this.leap = leap;
	}
	public String getDisplyDate() {
		return displyDate;
	}
	public void setDisplyDate(String displyDate) {
		this.displyDate = displyDate;
	}
	public String getSolarDate() {
		return solarDate;
	}
	public void setSolarDate(String solarDate) {
		this.solarDate = solarDate;
	}
	public boolean isToday() {
		return isToday;
	}
	public void setToday(boolean isToday) {
		this.isToday = isToday;
	}
}