package java230405;

public class Mouse extends Animal {
	
	String name = "��";
	public Mouse() {
		
	}
	public void CryingSound() {
		System.out.println(name +"�� ����Ÿ��ϴ�. ����");
		System.out.println(super.name +"�� ����Ÿ��ϴ�. ����");
		System.out.println(this.name +"�� ����Ÿ��ϴ�. ����");
	}
}
