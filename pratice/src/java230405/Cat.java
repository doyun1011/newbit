package java230405;

public class Cat extends Animal {
	String name = "�����";
	public Cat() {
		super();
	}
	public void CryingSound() {
		System.out.println(name +"�� ��ϴ�. �߿�");
		System.out.println(super.name +"�� ��ϴ�. �߿�");
		System.out.println(this.name +"�� ��ϴ�. �߿�");
	}

}
