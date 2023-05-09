package java0502;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerialTest {

	public static void main(String[] args) {
		try {
			
			//직렬화된 객체를 2진수로 기록할 파일을 지정하여
			//객체를 기록할 수 있는 ObjectOutputStream 객체를 생성한다.
			FileOutputStream fos = new FileOutputStream("PersonInfo.sel");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			
			//직렬화된 객체를 2개 생성한다.
			PersonInfo p1 = new PersonInfo("고길동", "서울", 35);
			PersonInfo p2 = new PersonInfo("이광", "서울", 45);
			
			//직렬화된 객체를 파일에 2진수로 기록한다.
			out.writeObject(p1);
			out.writeObject(p2);
			out.close();
			System.out.println("객체가 파일에 직렬화되어 기록되었습니다.");
		}catch(Exception e) {
			
		}
	}
}
