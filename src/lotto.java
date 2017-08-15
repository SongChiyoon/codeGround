import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 15..
 * 문제 : https://www.acmicpc.net/problem/6603
 */
public class lotto {
	
	static int[] d;
	static boolean[] v;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N;
		while(true){
			N = sc.nextInt();
			if(N == 0)
				break;
			
			d = new int[N];
			v = new boolean[N];
			for(int i=0;i<N;i++){
				d[i] = sc.nextInt();
			}
			for(int i=0;i<N;i++){
				dfs(i, N, "", 1);
			}
			System.out.println();

		}
	}
	public static void dfs(int current, int N, String log, int num){
		v[current] = true;
		log += d[current] +" ";
		if(num == 6){
			System.out.println(log);
			v[current] = false;
			return;
		}
		for(int i=0;i<N;i++){
			
			if( !v[i] && d[current] < d[i] ){
				dfs(i, N, log, num+1);
			}
		}
		v[current] = false;
		
		
	}
}
