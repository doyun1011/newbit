package java230405;

public class Dog extends Animal{
	String name ="��";
	public Dog() {
	}
	public void CryingSound() {
		System.out.println(name +"�� ¢���ϴ�. �۸�");
		System.out.println(super.name +"�� ¢���ϴ�. �۸�");
		System.out.println(this.name +"�� ¢���ϴ�. �۸�");
	}
}
