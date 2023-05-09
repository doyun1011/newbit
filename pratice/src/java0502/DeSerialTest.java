package java0502;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerialTest {

	public static void main(String[] args) {
		try {
			//직렬화된 객체의 2진 데이터가 기록된 파일을 지정하여
			//객체를 읽을 수 있는 ObjectInputStream 객체를 생성한다.
			FileInputStream fis = new FileInputStream("PersonInfo.sel");
			ObjectInputStream in = new ObjectInputStream(fis);
			
			//readObject() 메소드로 직렬화된 객체의
			//2진 데이터를 읽어서 객체 타입으로 캐스팅한다.
			PersonInfo p1 = (PersonInfo) in.readObject();
			PersonInfo p2 = (PersonInfo) in.readObject();
			
			System.out.println(p1);
			System.out.println(p2);
			in.close();
		}catch(Exception e) {
			
		}
	}
}
