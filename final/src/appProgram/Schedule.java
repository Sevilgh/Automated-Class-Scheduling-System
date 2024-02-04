package appProgram;

import java.util.ArrayList; 
import dataPack.Classes;
import dataPack.Course;
import dataPack.Department;

public class Schedule {
	private ArrayList<Classes> classes;
	private boolean isFitnessChanged = true;
	private double fitness = -1;
	private int classNumb = 0;
	private int numberOfConflicts = 0;
	private Data data;

	public Data getData() {
		return data;
	}

	public Schedule(Data data) {
		this.data = data;
		classes = new ArrayList<Classes>(data.getNumberOfClasses());
	}

	public Schedule initialize() {
		new ArrayList<Department>(data.getDepts()).forEach(dept -> {
			dept.getCourses().forEach(course -> {
				Classes newClass = new Classes(classNumb++, dept, course);
				newClass.setMeetingTime(
						data.getMeetingTimes().get((int) (data.getMeetingTimes().size() * Math.random())));
				newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
				newClass.setMaster(course.getMaster().get((int) (course.getMaster().size() * Math.random())));
				classes.add(newClass);
			});
		});
		return this;
	}

	public int getNumberOfConflicts() {
		return numberOfConflicts;
	}

	public ArrayList<Classes> getclasses() {
		isFitnessChanged = true;
		return classes;
	}

	public double getFitness() {
		if (isFitnessChanged == true) {
			fitness = calculateFitness();
			isFitnessChanged = false;
		}
		return fitness;
	}

	private double calculateFitness() {
		numberOfConflicts = 0;
		classes.forEach(x -> {
             classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
            	if(x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()) {
            		if(x.getRoom() == y.getRoom()) numberOfConflicts++;
            		if(x.getMaster() == y.getMaster()) numberOfConflicts++;
            	}
             });
		});
		return 1/(double)(numberOfConflicts + 1);
	}


}
