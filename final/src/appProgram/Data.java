package appProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.jdbc.Statement;

import dataPack.*;

public class Data {
	private ArrayList<RoomC> rooms = new ArrayList<RoomC>();
	private ArrayList<Master> masters = new ArrayList<Master>();
	private ArrayList<Department> depts;
	private ArrayList<TimeTableBell> meetingTimes;
	private ArrayList<Course> course = new ArrayList<Course>();
	private ArrayList<String> mastersName = new ArrayList<String>();

	private int numberOfClasses = 0;

	public Data() {
		initialize();
	}

	private Data initialize() {
		mastersName.add("master");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/final?user=root";
			Connection con;
			con = DriverManager.getConnection(url);
			java.sql.Statement st = con.createStatement();
			String query = "select * from rooms";
			ResultSet result = st.executeQuery(query);
			result.beforeFirst();
			while (result.next()) {
				rooms.add(new RoomC(result.getString("roomName")));
			}
																																															TimeTableBell meetTime1 = new TimeTableBell("MT1", 0, 1);TimeTableBell meetTime2 = new TimeTableBell("MT2", 0, 2);TimeTableBell meetTime3 = new TimeTableBell("MT3", 0, 3);TimeTableBell meetTime4 = new TimeTableBell("MT4", 0, 0);TimeTableBell meetTime5 = new TimeTableBell("MT5", 1, 1);TimeTableBell meetTime6 = new TimeTableBell("MT6", 1, 2);TimeTableBell meetTime7 = new TimeTableBell("MT7", 1, 3);TimeTableBell meetTime8 = new TimeTableBell("MT8", 1, 0);TimeTableBell meetTime9 = new TimeTableBell("MT9", 2, 1);TimeTableBell meetTime10 = new TimeTableBell("MT10", 2, 2);TimeTableBell meetTime11 = new TimeTableBell("MT11", 2, 3);TimeTableBell meetTime12 = new TimeTableBell("MT12", 2, 0);TimeTableBell meetTime13 = new TimeTableBell("MT13", 3, 1);TimeTableBell meetTime14 = new TimeTableBell("MT14", 3, 2);	TimeTableBell meetTime15 = new TimeTableBell("MT15", 3, 0);
			/*
			 * TimeTableBell meetTime16 = new TimeTableBell("MT16", 3, 3);
			 * 
			 * TimeTableBell meetTime17= new TimeTableBell("MT17", 4, 0); TimeTableBell
			 * meetTime18= new TimeTableBell("MT18", 4, 1); TimeTableBell meetTime19= new
			 * TimeTableBell("MT19", 4, 2); TimeTableBell meetTime20 = new
			 * TimeTableBell("MT20", 4, 3); TimeTableBell meetTime21 = new
			 * TimeTableBell("MT21", 5, 0); TimeTableBell meetTime22 = new
			 * TimeTableBell("MT22", 5, 1); TimeTableBell meetTime23 = new
			 * TimeTableBell("MT23", 5, 3); TimeTableBell meetTime24 = new
			 * TimeTableBell("MT24", 5, 2);
			 */
			
			

			meetingTimes = new ArrayList<TimeTableBell>(Arrays.asList(meetTime1, meetTime2, meetTime3, meetTime4,meetTime5,meetTime6, 
					meetTime7, meetTime8, meetTime9,meetTime10, meetTime11, meetTime12, meetTime13,meetTime14,
					meetTime15//, meetTime16,meetTime17,meetTime18, meetTime19,meetTime20
					));
			query = "select * from masterslessons";
			result = st.executeQuery(query);
			result.beforeFirst();
			while (result.next()) {

				masters.add(new Master(result.getString("mNum"), result.getString("mastersName")));
			}

			query = "select * from courses";

			result = st.executeQuery(query);
			result.last();
			result.beforeFirst();

			while (result.next()) {
				String master1 = result.getString("master1");
				String master2 = result.getString("master2");
				String master3 = result.getString("master3");
				
					for (int j = 0; j < masters.size(); j++) {
						if (master1.compareTo(masters.get(j).getName()) == 0 && master1.compareTo("nill") != 0) {
							course.add(new Course((result.getString("number")), result.getString("title"), masters.get(j),
									result.getInt("unitsCount")));
							if(result.getInt("unitsCount")>=3) {
								course.add(new Course((result.getString("number")), result.getString("title"), masters.get(j),
										result.getInt("unitsCount")));
							}
							
						} else if (master2.compareTo(masters.get(j).getName()) == 0 && master2.compareTo("nill") != 0) {
							course.add(new Course((result.getString("number")), result.getString("title"), masters.get(j),
									result.getInt("unitsCount")));
							if(result.getInt("unitsCount")>=3) {
								course.add(new Course((result.getString("number")), result.getString("title"), masters.get(j),
										result.getInt("unitsCount")));
							}
							
						} else if (master3.compareTo(masters.get(j).getName()) == 0 && master3.compareTo("nill") != 0) {
							course.add(new Course((result.getString("number")), result.getString("title"), masters.get(j),
									result.getInt("unitsCount")));
							if(result.getInt("unitsCount")>=3) {
								course.add(new Course((result.getString("number")), result.getString("title"), masters.get(j),
										result.getInt("unitsCount")));
							}
							
						}

					

				}
			}

			Department dept1 = new Department(course);

			depts = new ArrayList<Department>(Arrays.asList(dept1));
			depts.forEach(x -> numberOfClasses += x.getCourses().size());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException |

				SQLException e) {
			e.printStackTrace();
		}

		return this;
	}

	public ArrayList<RoomC> getRooms() {
		return rooms;
	}

	public ArrayList<Master> getMasters() {
		return masters;
	}

	public ArrayList<TimeTableBell> getMeetingTimes() {
		return meetingTimes;
	}

	public ArrayList<Course> getCourses() {
		return course;
	}

	public ArrayList<Department> getDepts() {
		return depts;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}
}
