package java0502;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) {
		//ip주소와 도메인 이름을 다루기 위한 클래스 InetAddress 
		InetAddress addr = null;
		InetAddress[] addrArr = null;
		String name = "www.naver.net";
		try {
			
			//인수 name에 대한 도메인과 ip정보를 얻은 후
			//도메인명과 IP주소를 각각 출력한다.
			addr = InetAddress.getByName(name);
			System.out.println("도메인명 : " + addr.getHostName());
			System.out.println("IP주소 : " + addr.getHostAddress());
			System.out.println("도메인명과 IP주소 : " + addr);
			System.out.println();
			
			//인수 name에 대한 도메인과 IP 정보 목록을 
			//배열에 저장하고 배열의 내용을 출력한다.
			addrArr = InetAddress.getAllByName(name);
			for (int i = 0; i < addrArr.length; i++) {
				System.out.println("IP 목록 [" + i + "]:" + addrArr[i]);
			}
			System.out.println();
			//로컬호스트의 도메인명과 IP 주소 정보를 addr에 할당하고
			//도메인명과 IP 주소를 각기 출력한다.
			addr = InetAddress.getLocalHost();
			System.out.println("로컬호스트 도메인명 : " + addr.getHostName());
			System.out.println("로컬호스트 IP 주소 : " + addr.getHostAddress());
			System.out.println();
		}catch(Exception e) {
			
		}
	}
}
