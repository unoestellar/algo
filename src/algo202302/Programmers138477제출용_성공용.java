package algo202302;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Programmers138477제출용_성공용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrr = {1, 1, 1, 1, 2, 2, 2, 3};
		System.out.println("anser: "+solution(2,arrr));
	}
	
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // 수확 하는 귤 각각은 사이즈가 달라진다. 
        //  "서로다른종류" 를 최소화하는 방법. 
        
        
        //  Map 구조에 한땀한땀 기록 . 
        HashMap<Integer,Integer> myMap = new HashMap<>();
        for (int i : tangerine) {
        	if(myMap.keySet().contains(Integer.valueOf(i))) {
        		Integer currVar = myMap.get(Integer.valueOf(i))+1;
        		myMap.put(Integer.valueOf(i), currVar);
        	}else {
        		//신규값이면 
        		myMap.put(Integer.valueOf(i), 1);
        	}        	
		}
                
        // keySet 에서 하나씩 젤 큰값을 뺄 예정이라 while 바깥에 선언 . 
        Set<Integer> mapSet = myMap.keySet();
        
        // keySet 열쇠꾸러미에서 최대귤을 가진 - 열쇠(idx)
        //하나씩 버린다.   set.remove(obj)
        while (k > 0) {
        	LinkedList<Integer> list = new LinkedList<>();
        	Integer maxIdx = 0;
        	Integer compared = 1;        	
			for (Integer i : mapSet) {
				list.add(myMap.get(i));
					if( myMap.get(compared) <= 
							myMap.get(i)) {						
						maxIdx = i;
					}					
				compared = i;
			}
			//내림차순정렬
			k = k- myMap.get(maxIdx);
			mapSet.remove(maxIdx);
			answer++;			
		}
        
        return answer;
    }
	

}
