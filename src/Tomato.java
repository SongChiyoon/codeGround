/*
 * problem : https://www.acmicpc.net/problem/7569
 */
import java.util.*;
public class Tomato {
	
	static class coord{

		int h, y, x;
		int age;
		coord(int h, int y, int x){
			this.h = h;
			this.y = y;
			this.x = x;
			age = 0;
		}
		public void setAge(int tAge) {
			this.age = tAge;
		}
	}
	static int[] th = {0,0,0,0,1,-1};
	static int[] tx = {1,-1,0,0,0,0};
	static int[] ty = {0,0,1,-1,0,0};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = Integer.parseInt(sc.next());
		int N = Integer.parseInt(sc.next());
		int H = Integer.parseInt(sc.next());
		int[][][] box = new int[H][N][M];
		age = new int[H][N][M];
		Queue<coord> q = new LinkedList<>();
		boolean flag = false;
		
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					box[h][i][j] = Integer.parseInt(sc.next());
					age[h][i][j] = -1;
					if(box[h][i][j] == 1) {
						age[h][i][j] = 0;
						coord source = new coord(h,i,j);
						source.setAge(0);
						q.add(source);
					}
					else if(box[h][i][j] == 0)
						flag = true;
				}
			}
			
		}
		if(flag){
			if(q.isEmpty()) {
				System.out.println(-1);
			}
			else {
				int maxAge = bfs(q, box, H,N,M);

				System.out.println(maxAge);
			}
		}
		else {
			System.out.println(0);
		}
	}
		
	static int[][][] age;

	public static int bfs(Queue<coord> q, int[][][] box, int H, int N, int M) {
		
		int maxAge = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			
			coord active = q.remove();
			maxAge = Math.max(active.age, maxAge);
			for(int i=0;i<6;i++) {
				int newH = active.h+th[i];
				int newY = active.y+ty[i];
				int newX = active.x+tx[i];
				if(newH>=0 && newH<H && newY>=0 && newY<N &&
						newX >=0 && newX<M && box[newH][newY][newX] == 0) {
					box[newH][newY][newX] = 1;
					coord newT = new coord(newH,newY,newX);
					newT.setAge(active.age+1);
					age[newH][newY][newX] = active.age+1;
					q.add(newT);
				}
			}
		}
		if(!check(box,H,N,M)) {
			return -1;
		}
		else
			return maxAge;
	}
	static boolean check(int [][][] box, int H, int N, int M) {
		for(int h=0;h<H;h++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(box[h][i][j] == 0)
						return false;
				}
			}
		}
		return true;
	}
}
