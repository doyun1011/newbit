package java0502;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		String inputData = null;
		
		FileReader fr;
		try {
			fr = new FileReader("sample.txt");
			BufferedReader br = new BufferedReader(fr);
			//readLine() 메소드로 라인 단위로 읽어 들인다.
			//readLine()은 bufferedReader만 있는 기능이다.
			while((inputData = br.readLine()) != null) {
				System.out.println(inputData);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
