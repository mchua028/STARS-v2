package stars;

import java.io.*;
import java.util.*;

public class IndexNo implements Serializable {
	private int indexnum;
	private int vacancy;
	private int waitlistlen;
	private ArrayList<Class> classes = new ArrayList<Class>();
	
	public IndexNo(int indexnum, int vacancy, ArrayList<Class> classes) {
		this.indexnum = indexnum;
		this.vacancy = vacancy;
		this.waitlistlen = 0;
		this.classes = classes;
	}
	
	public int getIndexNum() {
		return indexnum;
	}
	
	public int getVacancy() {
		return vacancy;
	}
	
	public int getWaitListLen() {
		return waitlistlen;
	}
	
	public ArrayList<Class> getClasses(){
		return classes;
	}
	
	public void setVacancy(int newvac) {
		this.vacancy = newvac;
		System.out.println("Vacancy updated.");
	}
	
	public void addClass(Class newclass) {
		classes.add(newclass);
		System.out.println("New class:");
		newclass.printClass();
		System.out.println("Added.");
	}
	
	public void removeClass(Class class1) {
		classes.remove(class1);
		System.out.println("Class:");
		class1.printClass();
		System.out.println("Removed.");
	}
	
	public void printIndexNo() {
		System.out.println("Index "+indexnum+" vacancy: "+vacancy+" waitlist: "+waitlistlen);
		for (Class class1:classes) {
			class1.printClass();
		}
		System.out.println();
		
	}
}
