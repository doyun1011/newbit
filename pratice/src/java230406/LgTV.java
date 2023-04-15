package java230406;

public class LgTV implements TV{

	
	public void powerOn() { 
	System.out.println("LgTV 전원을 켭니다.");
	
	}
	public void powerOff() { 
		System.out.println("LgTV 전원을 끕니다.");
		
	}
	public void volumeUp() {
		System.out.println("LgTV 볼륨을 올립니다.");
	}
	public void volumedown() {
		System.out.println("LgTV 볼륨을 내립니다.");
	}
}
