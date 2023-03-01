package algo001;

import java.util.Arrays;
import java.util.List;

public class Solution230116 {
	public static void main(String[] args) {
		System.out.println(minPartitions("27346209830709182346"));
	}
	public static int minPartitions(String n) {
		 // 핵심은 deci binary 의 길이 제한은 애초에 둔적 없었다는것. 
        // 1과 0 으로 구성되어있고  0이나 1 쓰는것이 자유롭다는것.
        // 32가 아니라 29만 생각해봐도.  11 11 + 1,1,1,1,1,1,1 즉 
        // 10^5 자리 수라 하더라도,  이 자리수중에서 가장 큰 수만큼의
        // deci binary 가 있다면,  표현이 가능하다는 결론에 이르는 
        // 아이디어 자체가 정답이다.  
        int maxNum = -1;
		List<String> strArr = Arrays.asList(n.split(""));
		for (String t : strArr) {
			maxNum = Math.max(maxNum, Integer.parseInt(t));
			
		}
		return maxNum;
    }
}




