import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 * Created by songchiyun on 2017. 8. 07..
 * https://www.acmicpc.net/problem/1613
 */
public class history_process {

	
	static boolean[][] v; 
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		v = new boolean[N+1][N+1];
		int[][] d = new int[N+1][N+1];
		boolean[][] m = new boolean[N+1][N+1];
		int k = sc.nextInt();
		
		for(int i=0;i<k;i++){
			int s = sc.nextInt();
			int t = sc.nextInt();
			d[s][t] = 1;			
		}
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(i == j)
					continue;
				else if(d[i][j] == 0){
					d[i][j] = Integer.MAX_VALUE;
					m[i][j] = true;
				}
			}
		}

		for(int l=1;l<=N;l++){
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					if(m[i][l] || m[l][j])
						continue;
					if(d[i][j] > d[i][l] + d[l][j])
					{
						d[i][j] = d[i][l] + d[l][j];
						m[i][j] = false;
					}
				}
			}
		}
		


		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			int ans;
			int source = sc.nextInt();
			int target = sc.nextInt();
			//find = find(source, target);
			if(m[source][target] != true){
				ans = -1;
			}
			else if(m[target][source] != true){
				ans = 1;
			}
			else{
				ans = 0;
			}
			
			System.out.println(ans);
		}
	}

		
	
}
