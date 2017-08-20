import java.util.Scanner;
import java.util.Stack;

/**
 * Created by songchiyun on 2017. 8. 20..
 * https://www.acmicpc.net/problem/2668
 */
public class choose_Number {

	static boolean[] v;
	static int[] d;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		v = new boolean[N+1];
		d = new int[N+1];
		for(int i=1;i<=N;i++)
			d[i] = sc.nextInt();
		visiting = new boolean[N+1];
		for(int i=1;i<=N;i++){
			
			int source = i;
			find = false;
			dfs(source, source, 1);
			
		}
		System.out.println(ans);
		for(int i=1;i<=N;i++){
			if(v[i])
				System.out.println(i);
		}
	}
	static int ans = 0;
	static boolean[] visiting;
	static boolean find;
	static void dfs(int source, int current, int step){
		
		if(d[current] == source){
			find = true;
			v[current] = true;
			ans += step;
			return;
		}
		if(!visiting[d[current]]){
			visiting[current] = true;
			dfs(source, d[current], step+1);
			if(!find)
				visiting[current] = false;
			else{
				v[current] = true;
			}
		}
		else{
			return;
		}
		
	}
}
