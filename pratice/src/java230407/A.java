package java230407;

public abstract class A {

	int n;

	abstract void f();
	public static void main(String[] args) {
		Student s = null;
		try {
			System.out.println(s.toString());
			
		} catch (NullPointerException e) {
			System.out.println("��ü�� �������ּ���.");
			System.out.println(e.getMessage());
		}
	}
}
