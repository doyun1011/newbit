package java230410;

public class ExceptionTest {

	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 0;
		try {
			int result = n1 / n2;
			System.out.println("result");
			
		} catch (ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");
			System.out.println(e.getMessage());
		}
	}
}
