import java.util.Scanner;

public class Bitonic {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N+1];
		int[][] d = new int[N+1][3];  // 1 : left / 2 : right
		
		for(int i = 1; i <= N; i++){
			
			a[i] = sc.nextInt();
			d[i][1] = 1;
			d[i][2] = 1;
		}
		
		
		for(int i = 2; i <= N-1; i++){
			
			for(int j = 1; j <= i; j++){
				if(a[i] > a[j]){
					d[i][1] = Math.max(d[i][1], d[j][1]+1);
				}
			
			}
			int[] temp = new int[N+1]; 
			int[] t = new int[2];  
			t[0] = a[i];
			t[1] = d[i][2];
			
			for(int j = i; j <= N; j++){
				
				if(t[0] > a[j]){
					temp[j] = Math.max(temp[j], t[1] + 1);
				}
			}
		}
	
	}
}
