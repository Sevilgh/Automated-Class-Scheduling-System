package dataPack;

import java.util.ArrayList;

public class Department {
	private String name="computer";
	private ArrayList<Course> courses;

	public Department(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public String getName() {
		return name;
	}

}
