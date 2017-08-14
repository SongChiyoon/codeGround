import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 15..
 * https://www.acmicpc.net/problem/2468
 */
public class Safe {

	static class coord{
		int y, x;
		coord(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] d = new int[N][N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int ans = Integer.MIN_VALUE;

		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++){
				d[i][j] = sc.nextInt();
				min = Math.min(min, d[i][j]);
				max = Math.max(max, d[i][j]);
			}
		
		for(int h=min-1; h<=max; h++){
			boolean[][] v = new boolean[N][N];
			int count = 0;
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(!v[i][j] && d[i][j] > h){
						Queue<coord> q = new LinkedList<>();
						q.add(new coord(j,i));
						v[i][j] = true;
						count++;
						
						while( !q.isEmpty() ){
							
							coord a = q.remove();
							int x = a.x;
							int y = a.y;
							if(x-1>=0){
								if(!v[y][x-1] && d[y][x-1] > h){
									q.add(new coord(x-1,y));
									v[y][x-1] = true;
								}
							}
							if(x+1<N){
								if(!v[y][x+1] && d[y][x+1] > h){
									q.add(new coord(x+1,y));
									v[y][x+1] = true;
								}
							}
							if(y-1>=0){
								if(!v[y-1][x] && d[y-1][x] > h){
									q.add(new coord(x,y-1));
									v[y-1][x] = true;
								}
							}
							if(y+1<N){
								if(!v[y+1][x] && d[y+1][x] > h){
									q.add(new coord(x,y+1));
									v[y+1][x] = true;
								}
							}
						}
					}

				}
			
			}
			ans = Math.max(ans, count);
			
		}
		System.out.println(ans);
	}
}
