package java0502;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamTest {

	public static void main(String[] args) {
		InputStream is = System.in; // 1바이트
		InputStreamReader isr = new InputStreamReader(is); // 2바이트
		int inputData = 0;
		//inputStream이 제공하는 read()메소드는 1바이트를 읽으며 해당문자의
		//정수 코드 반환
		System.out.println("데이터를 입력하세요: ");
		try {
			inputData = isr.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//바로 출력하면 정수 코드 값이 출력되어 문자로 캐스팅하면 문자가 출력된다.
		System.out.println("실제 입력된 데이터(정수): " +inputData);
		System.out.println("실제 입력된 데이터(문자): " +(char)inputData);
	}
}
