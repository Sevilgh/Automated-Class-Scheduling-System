package dataPack;

public class Bell {
	private String label;
	private int bellOfDay;

	public Bell(int bellOfDay) {
		this.bellOfDay=bellOfDay;
		switch (bellOfDay) {
		case 0:
			this.label="8:00-10:00";
			break;
		case 1:
			this.label="10:00-12:00";
			break;
		case 2:
			this.label="2:00-4:00";
			break;
		case 3:
			this.label="4:00-6:00";
			break;
		}
	}

	public int getBellOfDay() {
		return bellOfDay;
	}

	public String getLabel() {
		return label;
	}

}
