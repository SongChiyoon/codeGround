import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * problem : https://www.acmicpc.net/problem/4963
 */
public class NumIsland {

	static class coord{
		int y, x;
		coord(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			int n, m;
			m = sc.nextInt();
			n = sc.nextInt();
			if(m == 0 && n == 0)
				break;
			int[][] d = new int[n][m];
			boolean[][] v = new boolean[n][m];
			
			for(int i=0;i<n;i++)
				for(int j=0;j<m;j++)
					d[i][j] =sc.nextInt();
			
			int island_num = 0;
			Queue<coord> q = new LinkedList<>();
			for(int i=0;i<n;i++) {
				
				for(int j=0;j<m;j++) {
					
					if(d[i][j] == 1 && !v[i][j]) {
						island_num++;
						q.add(new coord(i, j));
						v[i][j] = true;
						while(!q.isEmpty()) {
							
							coord a = q.remove();
							int y = a.y;
							int x = a.x;
							if(y-1 >= 0 && d[y-1][x]==1 && !v[y-1][x]) {
								v[y-1][x] = true;
								q.add(new coord(y-1,x));
							}
							if(x-1>=0 && d[y][x-1]==1 && !v[y][x-1]) {
								v[y][x-1] = true;
								q.add(new coord(y,x-1));
							}
							if(y+1<n && d[y+1][x]==1 && !v[y+1][x]) {
								v[y+1][x] = true;
								q.add(new coord(y+1,x));
							}
							if(x+1<m && d[y][x+1]==1 && !v[y][x+1]) {
								v[y][x+1] = true;
								q.add(new coord(y,x+1));
							}
							if(x-1>=0) {
								if(y-1>=0 && d[y-1][x-1]==1 && !v[y-1][x-1]) {
									v[y-1][x-1] = true;
									q.add(new coord(y-1,x-1));
								}
								if(y+1<n && d[y+1][x-1]==1 && !v[y+1][x-1]) {
									v[y+1][x-1] = true;
									q.add(new coord(y+1,x-1));
								}
							}
							if(x+1<m) {
								if(y-1>=0 && d[y-1][x+1]==1 && !v[y-1][x+1]) {
									v[y-1][x+1] = true;
									q.add(new coord(y-1,x+1));
								}
								if(y+1<n && d[y+1][x+1]==1 && !v[y+1][x+1]) {
									v[y+1][x+1] = true;
									q.add(new coord(y+1,x+1));
								}
							}
							
						}
					}
				}
			}
			System.out.println(island_num);
		}
	}
}
