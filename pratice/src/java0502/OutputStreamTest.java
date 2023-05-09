package java0502;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OutputStreamTest {

	public static void main(String[] args) {
		//키보드를 입력스트림 객체에 할당하고, 콘솔을 출력스트림 객체에 할당한다.
		InputStream is = System.in;
		OutputStream out = System.out;
		System.out.print("데이터를 입력하세요 : ");
		
		int input;
		try {
			//입력 스트림 객체의 read() 메소드로 1바이트씩 읽어 들인다.
			input = is.read();
			System.out.println("실제 입력된 데이터: " + input);
			//출력 스트림 객체의 write() 메소드로 1바이트씩 문자로 캐스팅해서 출력한다.
			System.out.println("출력 데이터: ");
			out.write((char)input);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
