package java0508;

class MyThread3 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread3 실행... ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyThread4 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread4 실행... ");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class ThreadTest2 {

	public static void main(String[] args) {
		//1. Runnable 구현한 클래스를 작성한다.
		//2. run() 메소드를 작성한다.
		//3. Thread 객체를 생성하고 이때 1번의 클래스 객체를 인수로 전달한다.
		//4. start() 메소드를 호출하여 스레드를 시작한다.
		
		Thread t1 = new Thread(new MyThread3());
		Thread t2 = new Thread(new MyThread4());
		
		t1.start();
		t2.start();
		System.out.println("Main... 종료");

	}
}
