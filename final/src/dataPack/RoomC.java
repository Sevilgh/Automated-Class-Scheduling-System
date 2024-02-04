package dataPack;

public class RoomC {
	private String number;
	private int capacity=50;
	public RoomC(String number) {
		this.number=number;

	}
	public int getCapacity() {
		return capacity;
	}
	public String getNumber() {
		return number;
	}
}
