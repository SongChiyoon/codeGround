import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 7. 25..
 * 문제 : https://www.acmicpc.net/problem/1992
 */
public class quadTree {

	static int[][] img;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		img = new int[N][N];
		
		for(int i=0;i<N;i++){
			String line = sc.next();
			for(int j=0;j<N;j++){
				if(line.charAt(j) =='1')
					img[i][j] = 1;
				else
					img[i][j] = 0;
			}
		}
		solve(0,0,N);
		
	}
	public static void solve(int x, int y, int m){
		int check = check(x,y,m);
		if(check != -1){
			System.out.print(check); 
			return;
		}
		int n = m/2;
		System.out.print("(");
		solve(x,y,n);
		solve(x+n,y,n);
		solve(x,y+n,n);
		solve(x+n,y+n,n);
		System.out.print(")");

	}
	public static int check(int x, int y, int m){

		for(int j=y;j<y+m;j++){
			for(int i=x;i<x+m;i++){
				if(img[y][x] != img[j][i])
					return -1;
			}
		}
		return img[y][x];
	}
}
