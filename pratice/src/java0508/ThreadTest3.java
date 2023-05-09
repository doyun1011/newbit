package java0508;



//2
class MyRunnalble1 extends Thread {

	String myName;
	double result;

	public MyRunnalble1(String myName) {
		this.myName = myName;
	}

	public double getResult() {
		return result;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(myName +"말이 곧 출발합니다.");
		try {
			Thread.sleep(500);
			System.out.println("3");
			Thread.sleep(500);
			System.out.println("2");
			Thread.sleep(500);
			System.out.println("1");
			Thread.sleep(500);
			System.out.println(myName +" 출발!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long start = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			int random = ((int) (Math.random() * 500) + 1);
			try {
				Thread.sleep(random);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" " + myName);
		}
		
		long end = System.currentTimeMillis();
		double result = (double) (end - start) / 1000;
		System.out.println(myName +"말이 목표에 도착했습니다.");
		System.out.println(myName +"말의 기록은 " + result + "입니다.\n");
		this.result = result;
	}

}

public class ThreadTest3 {

	public static void main(String[] args) {
		MyRunnalble1 t1 = new MyRunnalble1("A");
		MyRunnalble1 t2 = new MyRunnalble1("B");

		System.out.println("A, B말의  기록 경주가 시작됩니다.");


		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();

		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("A말의 기록은 " +t1.getResult() +"\nB말의 기록은 " + t2.getResult());
		if (t1.getResult() < t2.getResult()) {
			System.out.println("우승은 A말입니다!");
		} else if (t1.getResult() > t2.getResult()) {
			System.out.println("우승은 B말입니다!");
		} else {
			System.out.println("놀랍게도 무승부입니다!");
		}
	}
}
