package stars;

import java.io.*;
import java.util.*;

public class Admin {
	private String username;
	private String password;
	
	public Admin(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public void start() {
		Scanner sc= new Scanner(System.in);
		int choice;
		do {
			System.out.println("Admin main page");
			System.out.println("1. add student");
			System.out.println("2. add course");
			System.out.println("3. update course");
			System.out.println("4. log out");
			
			choice = Integer.parseInt(sc.nextLine());
			if(choice==4) {
				System.out.println("logging out...");
				break;
			}
			
			if(choice<1||choice>4) {
				System.out.println("Invalid choice");
				continue;
			}
			
			switch(choice) {
			case 1:
				System.out.println("Enter student matriculation number:");
				String matric = sc.nextLine();
				System.out.println("Enter student username:");
				String username = sc.nextLine();
				System.out.println("Enter student name:");
				String name = sc.nextLine();
				System.out.println("Enter student gender:");
				String gender = sc.nextLine();
				System.out.println("Enter password");
				String pw = sc.nextLine();
				Student student = new Student(matric,username,name,gender,pw);
				student.addStudent();
				break;
			case 2:
				System.out.println("Enter course code:");
				String coursecode = sc.nextLine();
				System.out.println("Enter course name:");
				String coursename = sc.nextLine();
				System.out.println("Enter course AU:");
				int AU = Integer.parseInt(sc.nextLine());
				System.out.println("Enter number of indexes:");
				int indexes = Integer.parseInt(sc.nextLine());
				int indexnum,vac;
				ArrayList<IndexNo> indexnos = new ArrayList<IndexNo>();
				IndexNo index1;
				while (indexes>0) {
					System.out.println("Enter index number:");
					indexnum = Integer.parseInt(sc.nextLine());
					boolean indexadded = false;
					for (IndexNo index:indexnos) {
						if (index.getIndexNum()==indexnum) {
							System.out.println("Index number "+indexnum+" has already been added:");
							index.printIndexNo();
							indexadded = true;
							break;
						}
					}
					if (indexadded==true)
						continue;
					System.out.println("Enter vacancy:");
					vac = Integer.parseInt(sc.nextLine());
					int inttype;
					ArrayList<Class> classes = new ArrayList<Class>();
					Class class1;
					do {
						System.out.println("--------Add classes for course index--------"
								+ "\nChoose type of class to add:"
								+ "\n1. lecture"
								+ "\n2. tutorial"
								+ "\n3. lab"
								+ "\n4. quit");
						inttype = Integer.parseInt(sc.nextLine());
						
						if (inttype==4) {
							System.out.println("quitting...");
							break;
						}
						if (inttype<1||inttype>4) {
							System.out.println("Invalid choice.");
							continue;
						}
						
						//assume admin plan correctly!!!
						System.out.println("Enter class day:");
						int intday = Integer.parseInt(sc.nextLine());
						System.out.println("Enter class start time:");
						int starttime = Integer.parseInt(sc.nextLine());
						System.out.println("Enter class end time:");
						int endtime = Integer.parseInt(sc.nextLine());
						System.out.println("Enter weeks 1-13 for class, with space:");
						ArrayList<Integer> wks = new ArrayList<Integer>();
						String [] weeks = sc.nextLine().split(" ");
						for (String week:weeks) {
							int wk = Integer.parseInt(week);
							wks.add(wk);
						}
						
						switch(inttype) {
						case 1:
							class1 = new Lect(intday,starttime,endtime,wks);
							classes.add(class1);
							break;
						case 2:
							class1 = new Tut(intday,starttime,endtime,wks);
							classes.add(class1);
							break;
						case 3:
							class1 = new Lab(intday,starttime,endtime,wks);
							classes.add(class1);
							break;
						}
						
					}while (inttype!=4);
					index1 = new IndexNo(indexnum,vac,classes);
					indexnos.add(index1);
					indexes--;
				}
				Course course1 = new Course(coursecode,coursename,AU,indexnos);
				//addCourse(course1);
				course1.addCourse();
				break;
			case 3:
				System.out.println("Enter course code to update:");
				String c = sc.nextLine();
				Course s = Course.findCourse(c);
				if(s==null) {
					break;
				}
				int choice3;
				do {
					System.out.println("---------Update Course----------"
							+ "\n1.Update AU"
							+ "\n2.Add new index"
							+ "\n3.Remove index"
							+ "\n4.Update existing index"
							+ "\n5.Quit");
					choice3 = Integer.parseInt(sc.nextLine());
					if(choice3==5) {
						System.out.println("quitting...");
						break;
					}
					if(choice3<1||choice3>5) {
						System.out.println("Invalid choice");
						continue;
					}
					switch(choice3) {
					case 1:
						System.out.println("Enter new AU:");
						int newAU = Integer.parseInt(sc.nextLine());
						s.setAU(newAU);
						s.updateCourseToFile();
						break;
					case 2:
						IndexNo newindex;
						ArrayList<IndexNo> origindexnos = s.getIndexes();
						System.out.println("Enter index number:");
						int newindexnum = Integer.parseInt(sc.nextLine());
						boolean indexadded = false;
						for (IndexNo index:origindexnos) {
							if (index.getIndexNum()==newindexnum) {
								System.out.println("Index number "+newindexnum+" has already been added:");
								index.printIndexNo();
								indexadded = true;
								break;
							}
						}
						if (indexadded==true) {
							break;
						}
						System.out.println("Enter vacancy:");
						int newvac = Integer.parseInt(sc.nextLine());
						int inttype;
						ArrayList<Class> classes = new ArrayList<Class>();
						Class class1;
						do {
							System.out.println("--------Add classes for course index--------"
									+ "\nChoose type of class to add:"
									+ "\n1. lecture"
									+ "\n2. tutorial"
									+ "\n3. lab"
									+ "\n4. quit");
							inttype = Integer.parseInt(sc.nextLine());
							
							if (inttype==4) {
								System.out.println("quitting...");
								break;
							}
							if (inttype<1||inttype>4) {
								System.out.println("Invalid choice.");
								continue;
							}
							
							//assume admin plan correctly!!!
							System.out.println("Enter class day:");
							int intday = Integer.parseInt(sc.nextLine());
							System.out.println("Enter class start time:");
							int starttime = Integer.parseInt(sc.nextLine());
							System.out.println("Enter class end time:");
							int endtime = Integer.parseInt(sc.nextLine());
							System.out.println("Enter weeks 1-13 for class, with space:");
							ArrayList<Integer> wks = new ArrayList<Integer>();
							String [] weeks = sc.nextLine().split(" ");
							for (String week:weeks) {
								int wk = Integer.parseInt(week);
								wks.add(wk);
							}
							
							switch(inttype) {
							case 1:
								class1 = new Lect(intday,starttime,endtime,wks);
								classes.add(class1);
								break;
							case 2:
								class1 = new Tut(intday,starttime,endtime,wks);
								classes.add(class1);
								break;
							case 3:
								class1 = new Lab(intday,starttime,endtime,wks);
								classes.add(class1);
								break;
							}
							
						}while (inttype!=4);
						newindex = new IndexNo(newindexnum,newvac,classes);
						s.addIndex(newindex);
						s.updateCourseToFile();
						break;
					case 3:
						System.out.println("Enter index to remove:");
						int indextoremove = Integer.parseInt(sc.nextLine());
						ArrayList<IndexNo> origindexes = s.getIndexes();
						boolean indexfound = false;
						for(IndexNo index:origindexes) {
							if(index.getIndexNum()==indextoremove) {
								s.removeIndex(index);
								indexfound = true;
								break;
							}
						}
						if(indexfound)
							s.updateCourseToFile();
						else {
							System.out.println("Index "+indextoremove+" does not exist.");
						}
						break;
					case 4:
						System.out.println("Enter index number of index to update:");
						int indexnumtoupdate = Integer.parseInt(sc.nextLine());
						IndexNo indextoupdate = s.findIndexNo(indexnumtoupdate);
						if(indextoupdate==null) {
							break;
						}
						int choice4;
						do {
							System.out.println("----------Update existing index----------"
									+ "\n1. Update vacancy"
									+ "\n2. Add Class"
									+ "\n3. Remove Class"
									+ "\n4. Quit");
							choice4 = Integer.parseInt(sc.nextLine());
							if(choice4==4) {
								System.out.println("quitting...");
								break;
							}
							if(choice4<1||choice4>4) {
								System.out.println("Invalid choice");
								continue;
							}
							switch(choice4) {
							case 1:
								System.out.println("Enter new vacancy:");
								int newvacancy = Integer.parseInt(sc.nextLine());
								indextoupdate.setVacancy(newvacancy);
								s.UpdateIndex(indextoupdate);
								s.updateCourseToFile();
								break;
							case 2:
								Class class2;
								int newinttype;
								System.out.println("--------Add classes for course index--------"
										+ "\nChoose type of class to add:"
										+ "\n1. lecture"
										+ "\n2. tutorial"
										+ "\n3. lab"
										+ "\n4. quit");
								newinttype = Integer.parseInt(sc.nextLine());
				
								if(newinttype==4) {
									System.out.println("quitting...");
									break;
								}
								
								if (newinttype<1||newinttype>4) {
									System.out.println("Invalid choice.");
									break;
								}
								
								//assume admin plan correctly!!!
								System.out.println("Enter class day:");
								int intday = Integer.parseInt(sc.nextLine());
								System.out.println("Enter class start time:");
								int starttime = Integer.parseInt(sc.nextLine());
								System.out.println("Enter class end time:");
								int endtime = Integer.parseInt(sc.nextLine());
								System.out.println("Enter weeks 1-13 for class, with space:");
								ArrayList<Integer> wks = new ArrayList<Integer>();
								String [] weeks = sc.nextLine().split(" ");
								for (String week:weeks) {
									int wk = Integer.parseInt(week);
									wks.add(wk);
								}
								
								switch(newinttype) {
								case 1:
									class2 = new Lect(intday,starttime,endtime,wks);
									indextoupdate.addClass(class2);
									break;
								case 2:
									class2 = new Tut(intday,starttime,endtime,wks);
									indextoupdate.addClass(class2);
									break;
								case 3:
									class2 = new Lab(intday,starttime,endtime,wks);
									indextoupdate.addClass(class2);
									break;
								}
								s.UpdateIndex(indextoupdate);
								s.updateCourseToFile();
								break;
							case 3:
								System.out.println("Choose a class to remove:");
								ArrayList<Class> classes2 = indextoupdate.getClasses();
								for (int i=0; i<classes2.size(); i++) {
									System.out.print(i+1+". ");
									classes2.get(i).printClass();
								}
								System.out.println(classes2.size()+1+". Quit");
								int choice5 = Integer.parseInt(sc.nextLine());
								if(choice5==classes2.size()+1) {
									System.out.println("quitting...");
									break;
								}
								if(choice5<=classes2.size()&&choice5>=1) {
									indextoupdate.removeClass(classes2.get(choice5-1));
									s.UpdateIndex(indextoupdate);
									s.updateCourseToFile();
								}
								else {
									System.out.println("Invalid choice");
									break;
								}
								break;
							}
						}while(choice4!=4);
					}
				}while (choice3!=5);
			}
		}while(choice!=4);
		
	}
	
	/*public void addCourse(Course course) {
		List list = new ArrayList();
		boolean added = false;
		try {
			list = SerializeDB.readSerializedObject("courses.txt");
			System.out.println("nihao");
			if(list!=null) {
			for (int i = 0 ; i < list.size() ; i++) {
				System.out.println("hi2");
				Course s = (Course)list.get(i);
				System.out.println("course "+i+1+" code: "+s.getCourseCode());
				if (s.getCourseCode().equals(course.getCourseCode())) {
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
			System.out.println("coursecode: "+course.getCourseCode());
			list.add(course);
			System.out.println("course to be added: "+((Course)list.get(0)).getCourseCode());
			try	{
				SerializeDB.writeSerializedObject("courses.txt", list);
				List readedlist = SerializeDB.readSerializedObject("courses.txt");
				for (int i = 0 ; i < readedlist.size() ; i++) {
					Course s = (Course)readedlist.get(i);
					//
					
					
					System.out.println(s.getCourseCode());
					s.printCourse();
				}

			}  catch ( Exception e ) {
				System.out.println("write course file error");
				//System.out.println( "Exception >> " + e.getMessage() );
			}
		}
		
		else {
			System.out.println("Course with coursecode "+course.getCourseCode()+" already exist.");
		}

	}
	*/
	/*
	public void addStudent(String matric,String username,String name,String gender,String pw) {
		List list = new ArrayList();
		boolean added = false;
		try {
			list = SerializeDB.readSerializedObject("students.txt");
			System.out.println("nihao");
			if(list!=null) {
			for (int i = 0 ; i < list.size() ; i++) {
				System.out.println("hi2");
				Student s = (Student)list.get(i);
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
			Student student = new Student(matric,username,name,gender,pw);
			System.out.println("matric: "+student.getMatric());
			list.add(student);
			System.out.println("student to be added: "+((Student)list.get(0)).getMatric());
			try	{
				SerializeDB.writeSerializedObject("students.txt", list);

			}  catch ( Exception e ) {
				System.out.println("write student file error");
				//System.out.println( "Exception >> " + e.getMessage() );
			}
		}
		
		else {
			System.out.println("Student with matriculation number "+matric+" already exist.");
		}
		
	}
	*/
	
	
	//public boolean checkName(String username) {
		
	//}
	
}
