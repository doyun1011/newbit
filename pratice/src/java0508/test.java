package java0508;

public class test {
	static class MyRunnable implements Runnable {
		private String name;
		private double result;

		public MyRunnable(String name) {
			this.name = name;
		}

		public void run() {
			// 작업 수행
			result = 123.456; // 예시로 임의의 값 저장
		}

		public double getResult() {
			return result;
		}
	}

	public static void main(String[] args) {
		MyRunnable r = new MyRunnable("A");
		Thread t = new Thread(r);
		t.start();

		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		double result = r.getResult();
		System.out.println("Result: " + result);
	}
}
