package stars;

import java.io.*;
import java.util.*;

public class SerializeDB {
	
	public static List readSerializedObject(String filename) {
		List pDetails = new ArrayList();
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			System.out.println("opened file to read");
			in = new ObjectInputStream(fis);
			try {
				pDetails = (ArrayList) in.readObject();
			}
			catch(Exception e) {
				System.out.println();
			}
			System.out.println("file read");
			in.close();
		} catch (IOException ex) {
			System.out.println("read object IOError");
		} //catch (ClassNotFoundException ex) {
			//System.out.println("Classnotfounderror");
		//}
		// print out the size
		//System.out.println(" Details Size: " + pDetails.size());
		//System.out.println();
		return pDetails;
	}

	public static void writeSerializedObject(String filename, List list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			System.out.println("file to write to found");
			out = new ObjectOutputStream(fos);
			//System.out.println("course to write in: "+((Student)list.get(0)).getMatric());
			out.writeObject(list);
			System.out.println("object written");
			out.close();
		//	System.out.println("Object Persisted");
		} catch (IOException ex) {
			System.out.println("write object IOError");
		}
	}
	
	
	
}
