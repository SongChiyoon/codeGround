import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 20..
 * https://www.acmicpc.net/problem/9466
 */
public class term_project {

	static int[] d;
	static int N;
	static boolean[] v;
	static boolean[] visiting;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=0;t<T;t++){
			
			N = sc.nextInt();
			d = new int[N+1];
			v = new boolean[N+1];
			visiting = new boolean[N+1];
			for(int j=1;j<=N;j++){
			
				d[j]=sc.nextInt();
			}
			find = false;
			for(int j=1;j<=N;j++){
				if(!v[j]){
					dfs(j);
					
				}

			}
			
			int ans = 0;
			for(int j=1;j<=N;j++){
				if(!v[j]){
					ans++;
					//System.out.println(j);
				}
			}
			System.out.println("ans:"+ans);
			
			
		}
	}
	static boolean find;
	static int source;

	static void dfs(int current){
		
		if(visiting[d[current]]){
			visiting[current] = false;
			v[current] = true;
			find = true;
			source= d[current];
			return;
		}
		
		visiting[current] = true;
		dfs(d[current]);
		
		if(find){
			v[current] = true;
			if(current == source)
				find = false;							
		}


		visiting[current] = false;
		
	}
	
}
