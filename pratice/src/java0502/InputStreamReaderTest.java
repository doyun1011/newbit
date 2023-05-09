package java0502;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public static void main(String[] args) {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		int inputData = 0;
		
		char[] temp = new char[10];
		System.out.print("데이터를 입력하세요: ");
		//inputStreamReader의 read() 메소드의 인수가 배열인 경우,
		//배열의 크기만큼 배열에 문자를 읽어 들인 후 읽은 문자의 개수를 반환한다. 
		
		//2바이트씩 읽는다고 영어를 2개씩 읽지 않는다 하나씩만 읽는다.
		try {
			inputData = isr.read(temp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
		}
	}
}
