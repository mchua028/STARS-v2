package stars;

import java.io.*;
import java.util.*;

public class Lab extends Class implements Serializable{

	public Lab(int intday, int starttime, int endtime, ArrayList<Integer> wks) {
		super(intday, starttime, endtime, wks);
	}
	
	public void printClass() {
		System.out.print("Lab: "+getDay()+" "+getStartTime()+"-"+getEndTime()+" Weeks:");
		ArrayList<Integer> wks = getWks();
		int i = 0;
		for (i = 0;i<wks.size()-1;i++) {
			System.out.print(wks.get(i)+",");
		}
		System.out.println(wks.get(i));
		
	}
	
}
