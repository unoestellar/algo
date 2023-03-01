package algo001;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Solution230117_DFS {
	public static void main(String[] args) {
		int[] ar = {5,0,1,2,3,4};
		System.out.println(Arrays.toString(buildArray(ar)));
	}
    public static int[] buildArray(int[] nums) {
        // 순열로부터 배열을 형성하기 
        // 숫자 배열 NUMS 를 받아서 >  각 번째 인덱스로 된 배열로 재구성하는것. 

        //The elements in nums are distinct. 

        /* 힌트 없이 한다면 .  */
        // 얕은 복사를 한다?  복사 포기 
        int[] copynums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
			copynums[i] = nums[nums[i]];
		}
        return copynums;
        
    }
}




