package java230405;

public class Child extends Parent {

	int x;
	public Child() {
//		x=5; �ڽİ�ü�� �����Ƿ��� �θ� ������ ����Ǿ�� �ϹǷ� ������ ����.
		super(10);
		System.out.println("Child Class ������ �����");
	}
	public void cf() {
		System.out.println("Child Class �ɹ� �ż���  cf �����");
		super.n=-2;
	}
}
