package algo001;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		int[][] doublearr = {{2},{1,49,10,5}};
//		Integer[] intgerArr = Arrays.stream( dpmemo[len-1] ).boxed().toArray( Integer[]::new );
//		List<Integer> list = Arrays.asList(intgerArr);
//		answer = Collections.max(list);\
		int[] arr = doublearr[doublearr.length-1];
		// Integer[] intgerArr = Arrays.stream( intArr ).boxed().toArray( Integer[]::new );
		// List<Integer> list = Arrays.asList(intgerArr);
		// answer = Collections.max(list);
		for(int i=0; i< arr.length; i++){
		    answer=Math.max(answer, arr[i]);
		}
		System.out.println(answer);
	}

}
