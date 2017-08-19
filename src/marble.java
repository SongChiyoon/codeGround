import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 8. 19..
 * https://www.acmicpc.net/problem/2617
 */
public class marble {

	static int[][] d;
	static int N;
	static int cri;
	static boolean[][] v;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int cri = N/2;
		d = new int[N+1][N+1];
		int M = sc.nextInt();
		v = new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++){
			int target = sc.nextInt();
			int source = sc.nextInt();
			v[source][target] = true;
			d[source][target] = 1;
		}
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(i == j)
					continue;
				if(!v[i][j])
					d[i][j] = Integer.MAX_VALUE;

			}
		}
		for(int k=1;k<=N;k++){
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					if(!v[i][k] || !v[k][j])
						continue;
					if(d[i][j] > d[i][k] + d[k][j]){
						d[i][j] = d[i][k] + d[k][j];
						v[i][j] = true;
					}
				}
			}
		}
		int[] connect = new int[N+1];
		int[] connected = new int[N+1];
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				
				if(v[i][j]){
					connect[i] += 1;
					connected[j] += 1;
				}
				
			}
		}
		int ans = 0;
		for(int i=1;i<=N;i++){
			if(connect[i] > cri){
				ans += 1;
			}else if(connected[i] > cri){
				ans+= 1;
			}
		}
		System.out.println(ans);
		
	}
	public static void show(){
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(v[i][j]){
					System.out.print(1 + " ");
				}
				else
					System.out.print(0 +" ");
			}
			System.out.println();
		}
		System.out.println();

	}
}
