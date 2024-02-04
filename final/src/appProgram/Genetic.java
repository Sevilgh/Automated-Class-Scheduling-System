package appProgram;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Genetic {
	public Data data;

	public Genetic(Data data) {
		this.data = data;
	}

	public Population evolve(Population population) {
		return mutatePopulation(crossoverPopulation(population));
	}

	private Population mutatePopulation(Population population) {
		Population mutatePopulation = new Population(population.getSchedules().size(),data);
		ArrayList<Schedule> schedules=mutatePopulation.getSchedules();
		IntStream.range(0, MainController.elite).forEach(x->schedules.set(x, population.getSchedules().get(x)));
		return mutatePopulation;
	}

	Population crossoverPopulation(Population population) {
		Population crossoverPopulation = new Population(population.getSchedules().size(), data);
		IntStream.range(0,MainController.elite).forEach(x -> crossoverPopulation.getSchedules().set(x,population.getSchedules().get(x)));
		IntStream.range(MainController.elite, population.getSchedules().size()).forEach(x -> {
			if(MainController.crossoverRate > Math.random()) {
				Schedule schedule1 = selectTournamentPopulation(population).sortbyFitness().getSchedules().get(0);
				Schedule schedule2 = selectTournamentPopulation(population).sortbyFitness().getSchedules().get(0);
				crossoverPopulation.getSchedules().set(x,crossoverSchedule(schedule1, schedule2));

			}else crossoverPopulation.getSchedules().set(x,population.getSchedules().get(x));
		});
		return crossoverPopulation;
	}

	Schedule crossoverSchedule(Schedule schedule1, Schedule schedule2) {
		Schedule crossoverSchedule = new Schedule(data).initialize();
		IntStream.range(0,crossoverSchedule.getclasses().size()).forEach(x -> {
			if(Math.random() > 0.5) crossoverSchedule.getclasses().set(x,schedule1.getclasses().get(x));
			else crossoverSchedule.getclasses().set(x, schedule2.getclasses().get(x));
		});
		return crossoverSchedule;

	}
	 Schedule mutateSchedule(Schedule mutateSchedule) {
		 Schedule schedule = new Schedule(data).initialize();
		 IntStream.range(0, mutateSchedule.getclasses().size()).forEach(x ->{
			 if(MainController.mutationRate > Math.random()) mutateSchedule.getclasses().set(x, schedule.getclasses().get(x));
		 });
		 		 return mutateSchedule;
	 }
	 Population selectTournamentPopulation(Population population) {
		 Population tournamentPopulation = new Population(MainController.tournoment, data);
		 IntStream.range(0,MainController.tournoment).forEach(x -> {
			 tournamentPopulation.getSchedules().set(x,
					 population.getSchedules().get((int)(Math.random()* population.getSchedules().size())));
		 });
		 return tournamentPopulation;
	 }
}
