import java.util.HashMap;
import java.util.Scanner;

public class numberOfPaper {

	public static int[] ans = new int[3];
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static int[][] p;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		map.put(-1, 0);
		map.put(0, 1);
		map.put(1, 2);
		int N = sc.nextInt();
		p = new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				p[i][j] = sc.nextInt();
			}
		}
		solve(0,0,N);
		for(int i=0;i<3;i++)
			System.out.println(ans[i]);
	}
	public static void solve(int x, int y, int n){
		if(check(x,y,n)){
			ans[map.get(p[x][y])] += 1;
			return;
		}
		int m = n/3;
		for(int i=0; i<3;i++){
			for(int j=0;j<3;j++){
				solve(x+m*i, y+m*j, m);
			}
		}
	}

	public static boolean check(int x, int y, int n){
		for(int i = x; i < x+n; i++){
			for(int j = y; j < y+n; j++){
				if(p[x][y] != p[i][j])
					return false;
			}
		}
		return true;
		
	}
}
