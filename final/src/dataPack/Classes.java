package dataPack;
public class Classes {
private int id;
private Department dept;
private Course course;
private Master master;
private TimeTableBell meetingTime;
private RoomC room;
public Classes(int id,Department dept,Course course) {
	this.id=id;
	this.dept=dept;
	this.course=course;
}
public void setMaster(Master master) {
	this.master = master;
}
public void setMeetingTime(TimeTableBell meetingTime) {
	this.meetingTime = meetingTime;
}
public void setRoom(RoomC room) {
	this.room = room;
}
public int getId() {
	return id;
}
public Department getDept() {
	return dept;
}
public Course getCourse() {
	return course;
}
public Master getMaster() {
	return master;
}
public TimeTableBell getMeetingTime() {
	return meetingTime;
}
public RoomC getRoom() {
	return room;
}
public String toString() {
	return "["+dept.getName()+","+course.getNumber()+","+master.getId()+","+meetingTime.getId()+"]";
}
}
