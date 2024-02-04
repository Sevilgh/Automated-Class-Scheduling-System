package dataPack;

public class TimeTableBell {
	private String id;
	private Day day;
	private Bell bell;

	public TimeTableBell(String id,int day,int bell) {
		this.id=id;
		this.day=new Day(day);
		this.bell=new Bell( bell);
	}
	public String getId() {
		return id;
	}
	public String getDay() {
		return day.getLabel();
	}
	public int getBell() {
		return bell.getBellOfDay();
	}
	public String getTimeTableBell() {
		return day.getLabel()+" "+bell.getLabel();
	}
	
}
