import java.util.Scanner;

public class AscendingStair {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stairs = new int[301];
		int[][] d = new int[301][3];
		
		for(int i = 1; i <= N; i++){
			stairs[i] = sc.nextInt();
		}
		d[1][2] = stairs[1];
		d[1][1] = stairs[1];
		d[2][1] = d[1][1] + stairs[2];
		d[2][2] = stairs[2];
		
		for(int i = 3; i <= N; i++){
			d[i][1] = d[i-1][2] + stairs[i];
			d[i][2] = Math.max(d[i-2][1], d[i-2][2]) + stairs[i];
		}
		System.out.println(Math.max(d[N][1], d[N][2]));
		
	}
}
