package java0502;

import java.net.URL;

public class UrlTest {

	//URL: Uniform Resource Locator
	//인터넷 강의 서버들이 제공하는 다양한 자원들에 접근하기 위 한 주소
	//도메인명과 IP주소는 인터넷 상의 호스트 자체의 이름과 주소이고,
	//URL은 호스트 내의 서버가 가지고 있는 특정 자원에 대한 주소이다.
	//http://v.daum.net/v/20230502133610208
	//http <- 프로토콜(약속 혹은 통신규약), 호스트이름, 호스트내의 디렉토리, 자원의 이름.
	public static void main(String[] args) {
		try {
			//지정된 자원을 인수로 URL 객체를 생성한다.
			URL url = new URL("https://docs.oracle.com/javase/tutorial/essential/index.html");
			//URL 클래스가 제공하는 메소드들을 이용하여 해당 자원에 대한 정보를 출력한다.
			System.out.println("getAuthority() : " + url.getAuthority());
			System.out.println("getContent() : " + url.getContent());
			System.out.println("getDefaultPort() : " + url.getDefaultPort());
			System.out.println("getPort() : " + url.getPort());
			System.out.println("getFile() : " + url.getFile());
			System.out.println("getHost() : " + url.getHost());
			System.out.println("getPath() : " + url.getPath());
			System.out.println("getProtocol() : " + url.getProtocol());
			System.out.println("getQuery() : " + url.getQuery());
			System.out.println("getRef() : " + url.getRef());
			System.out.println("getUserInfo() : " + url.getUserInfo());
			System.out.println("toExternalForm() : " + url.toExternalForm());
			System.out.println("toURI() : " + url.toURI());
			
			
		}catch(Exception e ) {
			
		}
	}
}
