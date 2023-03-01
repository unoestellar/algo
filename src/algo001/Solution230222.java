package algo001;

import java.util.*;

public class Solution230222 {
	public static void main(String[] args) {
		String[] want = { "banana", "apple", "rice", "pork", "pot" };
		int[] number = { 3, 2, 2, 2, 1 };
		String[] discount = { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
				"pot", "banana", "apple", "banana" };
		System.out.println("ANSWER : " + saleEvent(want, number, discount));
	}

	public static int saleEvent(String[] want, int[] number, String[] discount) {
		int answer = 0;

		Map<String, Integer> wantedMap = new HashMap<>();

		// 원하는과일- 갯수 map 설정 완료 .
		for (int i = 0; i < want.length; i++) {
			wantedMap.put(want[i], (Integer) number[i]);
		}

		Map<String, Integer> discountMapTen;
//		        
		for (int p = 0; p < discount.length - 9; p++) {
			discountMapTen = new HashMap<String, Integer>();
			for (int i = p; i < p + 10; i++) {
				discountMapTen.put(discount[i], discountMapTen.getOrDefault(discount[i], 0) + 1);
			}
			boolean isEnough = true;
			for (String i : discountMapTen.keySet()) {

				if (discountMapTen.getOrDefault(i, 0) < wantedMap.getOrDefault(i, 0)) {
					isEnough = false;
				}
				if (wantedMap.getOrDefault(i, -1) == -1) {
					isEnough = false;
				}
			}
			if (isEnough) {
				answer = p + 1;
				break;
			}

		}

		return answer;

	}
}
