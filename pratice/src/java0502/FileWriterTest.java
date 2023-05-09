package java0502;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		try {
			FileReader fr  = new FileReader("sample.txt");
			FileWriter fw = new FileWriter("b.txt", true);
			
			int inputData = 0;
			while((inputData = fr.read())!= -1)  {
				//2바이트씩 읽고 기록하되 기존 파일의 데티어 뒤에 덧붙여 기록한다.
				fw.write(inputData);
			}
			fr.close();
			fw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
