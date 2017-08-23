import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 23..
 * https://www.acmicpc.net/problem/9205
 */
public class Beer_walking {

	static class coord{
		int x, y;
		int cost;
		coord(int x, int y){
			this.x = x;
			this.y = y;
			this.cost = 0;
		}
	}
	static coord[] d;
	static boolean[] v;
	static int N;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			
			N = sc.nextInt();
			d = new coord[N+2];
			v = new boolean[N+2];
			for(int i=0;i<=N+1;i++){
				int x = sc.nextInt();
				int y = sc.nextInt();
				d[i] = new coord(x,y);
			}
			find = false;
			dfs(0);
			if(find)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
		
	}
	static boolean find;
	static void dfs(int current){
		
		if(current == N+1){
			find = true;
			return;
		}
		v[current] = true;
		for(int i=1;i<=N+1;i++){
			
			if(!v[i] && 20*50 >= Math.sqrt(Math.pow(d[current].x-d[i].x, 2)+Math.pow(d[current].y-d[i].y, 2))){
				dfs(i);
				if(find)
					return;
			}
		}
		v[current] = false;
	}
}
