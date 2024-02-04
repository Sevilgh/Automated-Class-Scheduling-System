package dataPack;

import java.util.ArrayList;

public class Course {
	private String number;
	private String title;
	private int unitsCount;
	private int maxNumOfStudents=50;
	private ArrayList<Master> masters=new ArrayList<Master>();
	public Course(String number,String title,Master masters,int unitsCount) {
		this.number=number;
		this.title=title;
		this.masters.add(masters);
		this.unitsCount=unitsCount;
	}
	public String getNumber() {
		return number;
	}
	public String getTitle() {
		return title;
	}
	public int getUnitsCount() {
		return unitsCount;
	}
	public ArrayList<Master> getMaster(){
		return masters;
	}
	public int getMaxNumOfStudents() {
		return maxNumOfStudents;
	}

}
