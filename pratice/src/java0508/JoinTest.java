package java0508;

class MyThread5 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
public class JoinTest {

	public static void main(String[] args) {
		MyThread5 t1 = new MyThread5();
		MyThread5 t2 = new MyThread5();
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
	}
}
