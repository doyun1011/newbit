package java0502;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OutputWriterTest {

	public static void main(String[] args) {
		//10개의 문자를 기억할 수 있는 배열을 선언한다.
		char[] arr = new char[10];
		
		//키보드를 입력 스트림 리더 객체에 할당하고, 콘솔을 출력 스트림 리더에 할당한다.
		InputStreamReader isr = new InputStreamReader(System.in);
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		System.out.print("데이터를 입력하세요 : ");
		
		try {
			//10개의 문자를 읽어 배열에 저장한다.
			int input = isr.read(arr);
			System.out.print("실제 입력된 글자:");
			
			//배열 내의 10개 문자를 출력한다.
			osw.write(arr);
			osw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
