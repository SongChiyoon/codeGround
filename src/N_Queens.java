import java.util.Scanner;

/*
 * problem : https://www.acmicpc.net/problem/9663
 */
public class N_Queens {

	static int N;
	static boolean[][] d;
	static int ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new boolean[N][N];
		ans = 0;
		get(-1,0);
		System.out.println(ans);
	}
	static void get(int y, int x) {
		
		
		if(y == N-1) {

			ans++;
			return;
		}
		for(int i=0;i<N;i++) {
			if(check(y+1,i)) {
				d[y+1][i] = true;
				get(y+1,i);
				d[y+1][i] = false;
			}
		}
	}
	
	static boolean check(int y, int x) {
		
		int i,j;
		for(i=0;i<x;i++) 
			if(d[y][i])
				return false;	
		for(i=x+1;i<N;i++)
			if(d[y][i])
				return false;
		for(i=0;i<y;i++)
			if(d[i][x])
				return false;
		for(i=y+1;i<N;i++)
			if(d[i][x])
				return false;
		for(i=x-1,j=y-1;i>=0 && j>=0; i--,j--) {
			if(d[j][i])
				return false;
		}
		for(i=x+1,j=y+1;i<N && j<N; i++,j++) {
			if(d[j][i])
				return false;
		}
		
		for(i=x+1,j=y-1;i<N && j>=0; i++,j--) {
			if(d[j][i])
				return false;
		}
		for(i=x-1,j=y+1;i>=0 && j<N; i--,j++) {
			if(d[j][i])
				return false;
		}
		
		return true;
		
	}
}
