package java230412;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class Test {

	public static void main(String[] args) {
		//���ǰ� ���� �ٲ�  nums[i]�� ������� �� 
		//7 0 32 71 23 0 0 13  �� ��µǰ� ���弼��.
		int[] nums = {7, 21, 32, 71, 23, 33, 9, 13};
		for (int i = 0; i < nums.length; i++) {
			
			System.out.print(nums[i] + " ");
		}
	}
}
