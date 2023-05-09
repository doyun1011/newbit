package java0502;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("sample.txt");
			FileOutputStream fos = new FileOutputStream("b.txt");
			int inputData = 0;
			
			while((inputData = fis.read()) != -1) {
				fos.write(inputData);
			}
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
