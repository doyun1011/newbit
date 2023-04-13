package java230411;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileTest2 {

	public static void main(String[] args) {

		File f = new File("c:\\Temp\\obj.dat");

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		ArrayList<Student> slist = new ArrayList<Student>();
		slist.add(s1);
		slist.add(s2);
		slist.add(s3);
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(slist);
			oos.close();

			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			
			List<Student> rslist = (List<Student>)ois.readObject();
			for(Student stu: rslist) {
				System.out.println(stu);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}
