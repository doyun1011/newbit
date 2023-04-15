package java230405;

public class Tiger extends Animal {
	String name ="호랑이";
	public Tiger() {
	}
	public void CryingSound() {
		System.out.println(name +"가 포효합니다. 어흥");
		System.out.println(super.name +"가 포효합니다. 어흥");
		System.out.println(this.name +"가 포효합니다. 어흥");
	}
}
