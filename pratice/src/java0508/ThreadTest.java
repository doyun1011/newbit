package java0508;

class MyThread1 extends Thread {
	
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread1 실행... ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
class MyThread2 extends Thread {
	
	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread2 실행... ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


public class ThreadTest {

	public static void main(String[] args) {
		MyThread1 t1 = new MyThread1();
		MyThread2 t2 = new MyThread2();
		//start라는 메서드를 통해서 간접적으로 run 메소드가 실행되게 해야함
		t1.start();
		//run은 쓰레드를 사용하는 것이 아니다. 동기식으로 처리해버린다.
		t2.start();		
		System.out.println("Main... 종료");
	}
}
