import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by songchiyun on 2017. 8. 04..
 * https://www.acmicpc.net/problem/1987
 */
public class Alphabet {

	
	static char[][] d;
	static boolean[][] v;
	static HashMap<Character, Boolean> check;
	static int R, C;
	static int ans;
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); //¼¼·ÎÄ­
		C = sc.nextInt(); //°¡·Î
		check = new HashMap<>();
		d = new char[R+1][C+1];
		v = new boolean[R+1][C+1];
		for(int i=1;i<=R;i++){
			String input = sc.next();
			for(int j=1;j<=C;j++){
				d[i][j]= input.charAt(j-1);
				check.put(d[i][j], false);
			}
		}
		ans = 0;
		check.put(d[1][1], true);
		dfs(1,1,1);
		System.out.println(ans);
	}
	public static void dfs(int y, int x, int cost){

		if(x-1>=1){
			if(!check.get(d[y][x-1])){
				check.put(d[y][x-1], true);
				dfs(y,x-1,cost+1);
				check.put(d[y][x-1], false);

			}
		}
		if(x+1<=C){
			if(!check.get(d[y][x+1])){
				check.put(d[y][x+1], true);
				dfs(y,x+1,cost+1);
				check.put(d[y][x+1], false);

			}
		}
		if(y-1>=1){
			if(!check.get(d[y-1][x])){
				check.put(d[y-1][x], true);
				dfs(y-1,x,cost+1);
				check.put(d[y-1][x], false);

			}
		}
		if(y+1<=R){
			if(!check.get(d[y+1][x])){
				check.put(d[y+1][x], true);
				dfs(y+1,x,cost+1);
				check.put(d[y+1][x], false);

			}
		}

		ans = Math.max(ans, cost);

	}
}
