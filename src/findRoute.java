import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 8. 07..
 * https://www.acmicpc.net/problem/11403
 */
public class findRoute {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] d = new int[N][N];
		boolean[][] m = new boolean[N][N];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++){
				d[i][j] =sc.nextInt();
				if(d[i][j] == 0){
					d[i][j] = Integer.MAX_VALUE;
					m[i][j] = true;
				}
			}
		
		for(int k=0;k<N;k++){
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(m[i][k] || m[k][j]) continue;

					if(d[i][j] > d[i][k] + d[k][j]){
						m[i][j] = false;
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(m[i][j]) System.out.print(0+" ");
				else System.out.print(1+" ");
			}
			System.out.println();
		}
		
		
	}
}
