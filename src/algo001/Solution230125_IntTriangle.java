package algo001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution230125_IntTriangle {
	
	public static void main(String[] args) {
		int[][] a = {{7}, {3, 8},{8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution( a   ));;
	}
	/***
	 DP의 철학(?) : 썼던 파라미터의 리턴벨류를 재사용좀 하자.  
	  왜 매번 계산 또해야하냐 !! 
	  
 위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중,
  거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다.
  >> 거쳐간 숫자 합 가장큰경우! 
   아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽
    또는 왼쪽으로만 이동 가능합니다. 
    >> 대각선으로만 이동. 즉 한줄단위로만 이동되고, 수직2층하강따위없다. 
    예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
 >>  위의 유일한 3은  8 1 만 이동된다.  ( 내 idx 의 +0 ~ +1 만 이동가능하다. )  
	삼각형의 정보가 담긴 배열 triangle이 
	매개변수로 주어질 때,
	 거쳐간 숫자의 최댓값을 return 하도록 
	 solution 함수를 완성하세요.
	 */
	public static int solution(int[][] triangle) {

		int answer = 0;
		int depth = triangle.length;
		// 더큰거찾아 더하고 //그아래에서또 더큰거찾아더하고. 
		int aaa= triangle[0][0]+ triangle[1][0];
		int bbb= triangle[0][0]+ triangle[1][1];
		int ccc= Math.max(triangle[0][0]+ triangle[1][0], triangle[0][0]+ triangle[1][1]);
		System.out.println(depth);// 1~ 500  
		System.out.println(aaa);
		System.out.println(bbb);
		System.out.println(ccc);
		//int[][] a = {{7}, {3, 8},{8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};  
		// int[][] b = {{7}, {3, 8},{8, 1, 0}};
		int tempSum;
		int finalSum; 
        
		// 도화지를 그려라  . 비록 다 채우지 못해도. 
		int[][] temp = new int[triangle.length][triangle[triangle.length - 1].length];
        // 꼭대기 요소는 빼박이야. 
		temp[0][0] = triangle[0][0];

		
        for (int i = 1; i < triangle.length; i++) {
        	System.out.println("========" + i +"===============");
        	//1번친구 - 정해져있지. 
        	temp[i][0] = temp[i - 1][0] + triangle[i][0];
        	System.out.println("첫:"+temp[i][0]);
            // N번친구 - 너도 정해져있지.  
        	temp[i][i] = temp[i - 1][i - 1] + triangle[i][i];
        	System.out.println("끝:"+temp[i][i]);
            // 2번부터 ~  N-1번친구까지. 너도 max 가 끼긴해도 분절(함수화) 가능하지. 
        	for (int j = 1; j <= i - 1; j++) {
        		
        		System.out.println(temp[i - 1][j - 1]);
        		System.out.println(temp[i - 1][j]);
        		int myMax = Math.max(temp[i - 1][j - 1], temp[i - 1][j]);
        		System.out.println(myMax);System.out.println(triangle[i][j]);
                temp[i][j] =  triangle[i][j] +  myMax;
                
                answer = Math.max(answer, temp[i][j]);
                System.out.println("----------------");
            }
        	
        }
		
		/*
========1===============
========2===============
10
15
========3===============
18
16
16
15
========4===============
20
25
25
20
20
19
30

		*/
		return answer;

	}
	
	
	
	
}
