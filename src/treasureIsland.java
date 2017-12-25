/*
 * problem : https://www.acmicpc.net/problem/2589
 */
import java.util.*;
public class treasureIsland {
	static class coord{
		int y, x;
		int depth;
		coord(int y, int x){
			this.y = y;
			this.x = x;
			this.depth = 0;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		int N = Integer.parseInt(temp.split(" ")[0]);
		int M = Integer.parseInt(temp.split(" ")[1]);
		char[][] map = new char[N][M];
		for(int i=0;i<N;i++) {
			temp = sc.nextLine();
			for(int j=0;j<M;j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		boolean[][] v = new boolean[N][M];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(map[i][j] == 'L') {
					max = Math.max(max, bfs(map, new coord(i,j), N, M));
				}
				
			}
		}
		System.out.println(max);
		
	}
	static int[] tx = {1, -1, 0, 0};
	static int[] ty = {0, 0, 1, -1};
	public static int bfs(char[][] map, coord source, int N, int M) {
		boolean[][] v = new boolean[N][M];
		int depth = Integer.MIN_VALUE;
		Queue<coord> q = new LinkedList<>();
		q.add(source);
		v[source.y][source.x] = true;
		while(!q.isEmpty()) {
			coord active = q.remove();
			depth = Math.max(depth, active.depth);
			for(int i=0;i<4;i++) {
				if(tx[i]+active.x>=0 && tx[i]+active.x<M && ty[i]+active.y>=0 
						&& ty[i]+active.y<N && map[ty[i]+active.y][tx[i]+active.x] == 'L' && !v[ty[i]+active.y][tx[i]+active.x]) {
					v[ty[i]+active.y][tx[i]+active.x] = true;
					coord newC = new coord(ty[i]+active.y,tx[i]+active.x);
					newC.depth = active.depth+1;
					q.add(newC);
				}
			}
			
		}
		return depth;
		
	}
	public static void init(boolean[][] v, int N, int M) {
		for(int i=0;i<N;i++) 
			for(int j=0;j<M;j++)
				v[i][j] = false;
		
	}
}
