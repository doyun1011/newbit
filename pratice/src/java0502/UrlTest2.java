package java0502;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class UrlTest2 {

	public static void main(String[] args) {
		try {
			//지정된 인수로 URL 객체를 생성한다.
			URL page = new URL("https://docs.oracle.com/javase/tutorial/essential/index.html"); 
			//openStream() 메소드로 입력 스트림 객체를 생성해서 is에 할당한다.
			InputStream is = page.openStream();
			//버퍼를 이용하는 버퍼 입출력 객체를 생성한다.
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			FileWriter fw = new FileWriter("c:\\Temp\\urltest.html");
			BufferedWriter bw = new BufferedWriter(fw);
			//자원을 라인 단위로 읽고 기록한다.
			String line = br.readLine();
			while(line != null) {
				bw.write(line);
				
				line = br.readLine();
			}
			br.close();
			bw.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
}
