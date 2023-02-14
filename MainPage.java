package stars;

import java.util.*;
import java.io.*;

public class MainPage {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int domain = 0;
		do {
			System.out.println("Enter domain:\n1. Admin\n2. Student\n3. Quit App");
			domain = Integer.parseInt(sc.nextLine());
			
			if(domain==3) {
				System.out.println("qutting...");
				break;
			}
			
			if(domain<1||domain>3) {
				System.out.println("Invalid choice");
				continue;
			}
			
			System.out.println("Enter username:");
			String username = sc.nextLine();
			//check username exist
			
			System.out.println("Enter password:");
			String pw = sc.nextLine();
			//check password correct
			
			
			switch(domain){
			case 1:
				if (username.equals("admin") && pw.equals("cz2002")) {
					System.out.println("Logged in as admin");
					Admin admin = new Admin("admin", "cz2002");
					admin.start();
				}
				else {
					System.out.println("Wrong username/password");
				}
				break;
			case 2:
				System.out.println("Logged in as student");
				//Student student  = new Student();
				//student.start();
				break;
			}
		}while (domain!=3);
	}
	
}
