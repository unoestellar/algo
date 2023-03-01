package algo001;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Solution230124_baek2178 {
		/**\
		N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1
미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 
 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
  한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 
칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

		 */
		static int[][] map;
		//상하좌우
		static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
		static int n;
		static int m;
		static boolean[][] visited;

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			/*  N M 사이즈 받기 */
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			/*  미로받기  */
			map = new int[n][m];
			for(int i=0; i<n; i++) {
				System.out.println("LINE:"+i);
				String s = br.readLine();
				for(int j=0; j<m; j++) {
					map[i][j] = s.charAt(j) - '0';
					//System.out.println(map[i][j]);
				}
			}
			/*  기방문지 체크용 > 생성시점 ALL false   */
			visited = new boolean[n][m];
			//System.out.println(visited[0][0]);
			// 암것도 없을 때 
			visited[0][0] = true;
			bfs(0, 0);// 로직 
			System.out.println(map[n-1][m-1]);
		}

		public static void bfs(int x, int y) {
			// 큐선언 
			Queue<int[]> myQueue = new LinkedList<>();
			myQueue.add(new int[] {x,y});
			//종료시점 - 큐에있는 전부 사라질시
			while(!myQueue.isEmpty()) {
				int now[] = myQueue.poll();// 큐의 맨 앞값 꺼내와라 
				System.out.println(Arrays.toString(now));
				int nowX = now[0];
				int nowY = now[1];
				
				for(int i=0; i<4; i++) {//4방면
					int nextX = nowX + direction[i][0];
					int nextY = nowY + direction[i][1];
					//벽치기 방지
	                if (
	                		(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m)
	                		&&  !visited[nextX][nextY]
	                				&&   map[nextX][nextY] != 0
	                				) {
	    		        //좌표째로 add 
	    		        myQueue.add(new int[] {nextX, nextY});
	    		        // 횟수
	    		        // Max 1만칸 - 100 * 100  
	    		        
	    		        map[nextX][nextY] = map[nowX][nowY] + 1; 
	            		visited[nextX][nextY] = true;
	                }


				}
			}
		}
	}
