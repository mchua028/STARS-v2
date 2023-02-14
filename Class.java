package stars;

import java.io.*;
import java.util.*;

public class Class implements Serializable{
	private int intday;
	private String day;
	private int starttime;
	private int endtime;
	private ArrayList<Integer> wks = new ArrayList<Integer>();
	
	public Class(int intday,int starttime,int endtime,ArrayList<Integer>wks) {
		this.intday = intday;
		this.day = convertDayToString();
		this.starttime = starttime;
		this.endtime = endtime;
		this.wks = wks;
	}
	
	private String convertDayToString() {
		ArrayList<String> days = new ArrayList<String>();
		days.add("Monday");
		days.add("Tuesday");
		days.add("Wednesday");
		days.add("Thursday");
		days.add("Friday");
		days.add("Saturday");
		return days.get(intday-1);
	}
	
	public String getDay() {
		return day;
	}
	
	public int getStartTime() {
		return starttime;
	}
	
	public int getEndTime() {
		return endtime;
	}
	
	public ArrayList<Integer> getWks(){
		return wks;
	}
	
	public void printClass() {}
}
