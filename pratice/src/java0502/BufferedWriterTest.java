package java0502;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferedWriterTest {

	public static void main(String[] args) {
		try {
			FileReader fr;
			fr = new FileReader("sample.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("out.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			int count = 1;
			
			String line = br.readLine();
			while(line != null) {
				//읽은 라인을 공백을 기준으로 토큰으로 구분하는 객체를 생성한다.
				//문자열을 토큰화 시키겠다. 공백을 기준으로 토큰화 했다.
				//한줄에 공백이 3개라면 st는 토큰 3개를 저장하고 있다.
				StringTokenizer st = new StringTokenizer(line, "");
				// 더 읽어올 토큰이 없다면 false를 반환하고 그렇지 않으면 true를 반환한다.
				while(st.hasMoreTokens()) {
					//읽을 라인 내에 '자바'라는 단어가 있으면 출력 버퍼에 기록하고
					//버퍼의 내용을 파일에 기록한다.
					//당연하게도 토큰을 순차적으로 읽는 코드이다.
					//다음 토큰이 없다면 예외를 반환시킨다. 
					if(st.nextToken().equals("자바")) {
						bw.write(line);
						bw.flush();
						bw.newLine();
						break;
					}
				}
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
