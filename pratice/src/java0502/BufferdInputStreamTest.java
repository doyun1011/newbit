package java0502;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferdInputStreamTest {

	public static void main(String[] args) {
		int inputData = 0;
		try {
			//주스트림
			FileInputStream fis = new FileInputStream("sample.txt");
			//FileInputStream 객체를 인수로 BufferedInputStream 객체를 생성한다.
			//보조스트림 - 버퍼에 담아둔다. 
 			BufferedInputStream bis = new BufferedInputStream(fis);
			//버퍼에서 1바이트씩 읽어 들인다. close 없어도 읽어들이는데는 큰 문제는 없는듯하다.
			while((inputData = bis.read()) != -1){
				System.out.println((char)inputData);
			}
			bis.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
