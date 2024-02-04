package appProgram;

import java.util.ArrayList;
import dataPack.Classes;
import appProgram.Schedule;
import dataPack.*;


public class MainController {
	public static final int populationSize =9;
	public static final double mutationRate = 0.1;
	public static final double crossoverRate = 0.9;
	public static final int tournoment = 3;
	public static final int elite = 1;
	private int scheduleNumb=0; 
	private int classNumb=1;
	private Data data;
	public static void main(String[] args) {
		MainController driver = new MainController();
		driver.data= new Data();
		int generationNumber=0;	
		Genetic geneticAlgo=new Genetic(driver.data);
		Population population=new Population(MainController.populationSize, driver.data).sortbyFitness();
		
		driver.printScheduleTable(population.getSchedules().get(0), generationNumber);
		driver.classNumb=1;
		while(population.getSchedules().get(0).getFitness()!=1.0) {
			population=geneticAlgo.evolve(population).sortbyFitness();
			driver.scheduleNumb=0;
			int ended=driver.printScheduleTable(population.getSchedules().get(0), generationNumber);
			if(ended==1)
				break;
			driver.classNumb=1;
		}
		
	}

	
	private int printScheduleTable(Schedule schedule,int generation) {
	
		if(schedule.getFitness()==1) {
			ArrayList<Classes> classes=schedule.getclasses();
			System.out.println("---------------------------------------------------------------------------------------");
			System.out.println("");
			System.out.println("Class   |   dept   |        course         |  room  |    master    | class time");
			System.out.println("---------------------------------------------------------------------------------------");
			classes.forEach(x->{

			int majorIndex=data.getDepts().indexOf(x.getDept());
			int coursesIndex=data.getCourses().indexOf(x.getCourse());
			int roomsIndex=data.getRooms().indexOf(x.getRoom());
			int mastersIndex=data.getMasters().indexOf(x.getMaster());
			int meetingTimeIndex=data.getMeetingTimes().indexOf(x.getMeetingTime());
			System.out.println(" ");
			System.out.print(String.format("  %1$02d  ", classNumb)+"  | ");
			System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName())+ " | ");
			System.out.print(String.format("%1$21s", data.getCourses().get(coursesIndex).getTitle())+
					" |");
			System.out.print(String.format("%1$10s", data.getRooms().get(roomsIndex).getNumber()+
					" | "));
			System.out.print(String.format("%1$15s", data.getMasters().get(mastersIndex).getName()+
					"  | "));
			System.out.println(data.getMeetingTimes().get(meetingTimeIndex).getTimeTableBell()
					);
			classNumb++;
			});
			return 1;
		}
		return 0;
	}
     
}
