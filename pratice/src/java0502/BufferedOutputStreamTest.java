package java0502;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		//파일을 인수로 FileOutputStream 객체를 생성하고
		//그 객체를 인수로 BufferOutputStream 객체를 생선한다.
		try {
			FileOutputStream fos = new FileOutputStream("alph.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			//a ~ z 문자를 기록한다.
			for (int i = 'a'; i < 'z'; i++) {
				bos.write(i);
			}
			//버퍼에 기록된 데이터를 실제 파일에 기록한다.
			//flush만으로도 저장된다.
			bos.flush();
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
