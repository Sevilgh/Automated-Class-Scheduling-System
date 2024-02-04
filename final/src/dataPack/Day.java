package dataPack;

public class Day {
	private String label;
	private int dayOfWeek;

	public Day(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
		switch (dayOfWeek) {
		case 0:
			this.label="Saturday";
			break;
		case 1:
			this.label="Sunday";
			break;
		case 2:
			this.label="Monday";
			break;
		case 3:
			this.label="Tuesday";
			break;
		case 4:
			this.label="Thursday";
			break;
		

		}
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public String getLabel() {
		return label;
	}
}
