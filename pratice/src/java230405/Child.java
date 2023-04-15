package java230405;

public class Child extends Parent {

	int x;
	public Child() {
//		x=5; 자식객체가 생성되려면 부모가 생성이 선행되어야 하므로 에러가 난다.
		super(10);
		System.out.println("Child Class 생성자 실행됨");
	}
	public void cf() {
		System.out.println("Child Class 맴버 매서드  cf 실행됨");
		super.n=-2;
	}
}
