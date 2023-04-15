package java230412;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class Test {

	public static void main(String[] args) {
		//조건과 값을 바꿔  nums[i]를 출력했을 때 
		//7 0 32 71 23 0 0 13  이 출력되게 만드세요.
		int[] nums = {7, 21, 32, 71, 23, 33, 9, 13};
		for (int i = 0; i < nums.length; i++) {
			
			System.out.print(nums[i] + " ");
		}
	}
}
