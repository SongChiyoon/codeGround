/*
 * https://www.acmicpc.net/problem/1937
 */
import java.util.*;
public class GreedyPanda {

	static int[][] Forest;
	static int[][] d;
	
	static int N;
	static int[] dy={0, 0, 1, -1};
	static int[] dx={1,-1, 0,  0};
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Forest = new int[N][N];
		d = new int[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++){
				Forest[i][j] = sc.nextInt();
				d[i][j] = -1;
			}

		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++){
				if(d[i][j] == -1){
					dfs(i,j);
				}
			}
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				max = Math.max(d[i][j], max);
			}
		}
		System.out.println(max+1);
		
	}
	static int dfs(int y, int x){
		
		boolean flag = false;
		int maxStep = Integer.MIN_VALUE;
		
		for(int i=0;i<4;i++){
			
			int tx = x + dx[i];
			int ty = y + dy[i];
			
			if(tx>=0 && tx<N && ty>=0 && ty<N){

				if(Forest[ty][tx] > Forest[y][x]){
					flag = true;
					if(d[ty][tx] == -1){
						int step = dfs(ty,tx);
						maxStep = Math.max(step, maxStep);
					}
					else{
						maxStep = Math.max(d[ty][tx], maxStep);
					}
				}
			}
			
			
		}
		if(!flag){
			d[y][x] = 0;
			return 0;
		}
		else{
			d[y][x] = maxStep+1;
			return maxStep+1;
		}
			
	}
}
