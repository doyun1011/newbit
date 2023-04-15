package java230410;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fileReaderTest {

	public static void main(String[] args) {
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("c:\\Temp\\diary230410.txt");
			char[] buff = new char[300];
			fr.read(buff);
			
			for (int i = 0; i < buff.length; i++) {
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
