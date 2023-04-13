package java230412;

public class TestTest {

	public static void main(String[] args) {
//		Test t = new Test();
//		
//		t.getN();
//		System.out.println(t);
		int[][] nums = new int[3][3];

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				nums[i][j] = j + 1;
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
	}
}
