package java230405;

public class Parent {

	int n;

	public Parent(int n) {
		System.out.println("Parent Class 생성자 실행됨");
	}
	
	public void pf() {
		System.out.println("Parent Class 맴버 매서드  pf 실행됨");
		System.out.println("부모 변수의 값은" + n);
	}
}
