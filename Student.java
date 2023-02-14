package stars;

import java.io.*;
import java.util.*;

//add course&index(can choose other index if no vacancy), deregister course, change index for registered course
public class Student implements Serializable{
	private String matric;
	private String username;
	private String name;
	private String gender;
	private String pw;
	private int AU;
	
	public Student(String matric,String username,String name,String gender,String pw) {
		this.matric = matric;
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.pw = pw;
		this.AU = 0;
	}
	
	public String getMatric() {
		return matric;
	}
	
	public void addStudent() {
		List list = new ArrayList();
		boolean added = false;
		Student s=null;
		try {
			list = SerializeDB.readSerializedObject("students.txt");
			System.out.println("nihao");
			if(list!=null) {
			for (int i = 0 ; i < list.size() ; i++) {
				System.out.println("hi2");
				s = (Student)list.get(i);
				System.out.println("student "+i+1+" matric: "+s.getMatric());
				if (s.getMatric().equals(matric)) {
					added = true;
					break;
				}
			}
			}
		}
		catch(Exception e) {
			System.out.println("creating new students file...");
			//System.out.println("Exception >> "+e.getMessage());
		}
		
		if (added==false) {
			System.out.println("matric: "+matric);
			list.add(this);
			System.out.println("student to be added: "+((Student)list.get(list.size()-1)).getMatric());
			try	{
				SerializeDB.writeSerializedObject("students.txt", list);
				List readedlist = SerializeDB.readSerializedObject("students.txt");
				for (int i = 0 ; i < readedlist.size() ; i++) {
					s = (Student)readedlist.get(i);
					//
					
					
					//System.out.println(s.getCourseCode());
					s.printStudent();
				}

			}  catch ( Exception e ) {
				System.out.println("write student file error");
				//System.out.println( "Exception >> " + e.getMessage() );
			}
		}
		
		else {
			System.out.println("Student with matriculation number "+matric+" already exist:");
			s.printStudent();
		}
	}
	
	public void printStudent() {
		System.out.println(matric + " " + username + " " + name + " " + gender + " " + pw + " current AUs:" + AU);
	}
	
	public void start() {
		System.out.println("Student main page");
	}
}
