package stars;

import java.io.*;
import java.util.*;

public class Course implements Serializable {//file will be empty once you change class
	private String coursecode;
	private String coursename;
	private int AU;
	private ArrayList<IndexNo> indexes = new ArrayList<IndexNo>();
	
	public Course(String coursecode, String coursename, int AU, ArrayList<IndexNo> indexes) {
		this.coursecode = coursecode;
		this.coursename = coursename;
		this.AU = AU;
		this.indexes = indexes;
	}
	
	
	public String getCourseCode() {
		return coursecode;
	}
	
	public String getCourseName() {
		return coursename;
	}
	
	public int getAU() {
		return AU;
	}
	
	public ArrayList<IndexNo> getIndexes() {
		return indexes;
	}
	
	public void setAU(int newAU) {
		this.AU = newAU;
		System.out.println("AU updated.");
	}
	
	public void addIndex(IndexNo index) {
		indexes.add(index);
		System.out.println("Index "+index.getIndexNum()+" added.");
	}
	
	public void removeIndex(IndexNo index) {
		indexes.remove(index);
		System.out.println("Index "+index.getIndexNum()+" removed.");
		
	}
	
	public void printCourse() {
		System.out.println(coursecode+" "+coursename+" "+AU+"AU");
		System.out.println("------------------------------");//30
		for (IndexNo index:indexes) {
			index.printIndexNo();
		}
	}
	
	public void addCourse() {
		List list = new ArrayList();
		boolean added = false;
		Course s=null;
		try {
			list = SerializeDB.readSerializedObject("courses.txt");
			System.out.println("nihao");
			if(list!=null) {
			for (int i = 0 ; i < list.size() ; i++) {
				System.out.println("hi2");
				s = (Course)list.get(i);
				System.out.println("course "+i+1+" code: "+s.getCourseCode());
				if (s.getCourseCode().equals(coursecode)) {
					added = true;
					break;
				}
			}
			}
		}
		catch(Exception e) {
			System.out.println("creating new courses file...");
			//System.out.println("Exception >> "+e.getMessage());
		}
		
		if (added==false) {
			System.out.println("coursecode: "+coursecode);
			list.add(this);
			System.out.println("course to be added: "+((Course)list.get(list.size()-1)).getCourseCode());
			try	{
				SerializeDB.writeSerializedObject("courses.txt", list);
				List readedlist = SerializeDB.readSerializedObject("courses.txt");
				for (int i = 0 ; i < readedlist.size() ; i++) {
					s = (Course)readedlist.get(i);
					//
					
					
					//System.out.println(s.getCourseCode());
					s.printCourse();
				}

			}  catch ( Exception e ) {
				System.out.println("write course file error");
				//System.out.println( "Exception >> " + e.getMessage() );
			}
		}
		
		else {
			System.out.println("Course with coursecode "+coursecode+" already exist:");
			s.printCourse();
		}

	}
	
	
	public IndexNo findIndexNo(int indexnum) {
		boolean found = false;
		IndexNo index = null;
		for(IndexNo i:indexes) {
			if(i.getIndexNum()==indexnum) {
				index = i;
				System.out.println("Index found:");
				index.printIndexNo();
				found = true;
				break;
			}
		}
		if(found)
			return index;
		else {
			System.out.println("Index not found");
			return null;
		}
	}
	
	public void UpdateIndex(IndexNo index) {
		for(IndexNo i:indexes) {
			if(i.getIndexNum()==index.getIndexNum()) {
				indexes.remove(i);
				indexes.add(index);
				System.out.println("Index "+index.getIndexNum()+" updated:");
				indexes.get(indexes.size()-1).printIndexNo();
				break;
			}
		}
	}
	
	public static Course findCourse(String coursecode) {
		boolean found = false;
		Course s = null;
		try	{
			List readedlist = SerializeDB.readSerializedObject("courses.txt");
			for (int i = 0 ; i < readedlist.size() ; i++) {
				s = (Course)readedlist.get(i);
				
				if(s.getCourseCode().equals(coursecode)) {
					System.out.print("Course found:");
					s.printCourse();
					found = true;
					break;
				}
			}

		}  catch ( Exception e ) {
			System.out.println("find course error");
			//System.out.println( "Exception >> " + e.getMessage() );
		}
		if(found)
			return s;
		else{
			System.out.println("Course not found.");
			return null;
		}
	}
	
	public void updateCourseToFile() {
		try	{
			Course s=null;
			List readedlist = SerializeDB.readSerializedObject("courses.txt");
			for (int i = 0 ; i < readedlist.size() ; i++) {
				s = (Course)readedlist.get(i);
				
				if(s.getCourseCode().equals(coursecode)) {
					readedlist.remove(i);
					break;
				}
			}
			readedlist.add(this);
			SerializeDB.writeSerializedObject("courses.txt", readedlist);
			System.out.println("Course "+coursecode+" updated. Updated list of courses:");
			readedlist = SerializeDB.readSerializedObject("courses.txt");
			for (int i = 0 ; i < readedlist.size() ; i++) {
				s = (Course)readedlist.get(i);
				s.printCourse();
			}

		}  catch ( Exception e ) {
			System.out.println("update course error");
			//System.out.println( "Exception >> " + e.getMessage() );
		}
		
	}
}
