import java.util.Scanner;

public class MaxSum_list {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N+1];
		int[] d = new int[N+1];
		
		for(int i = 1; i <= N; i++){
			a[i] = sc.nextInt();
			d[i] = a[i];
		}
		
		for(int i = 1; i <= N; i++){
			
			for(int j = i-1; j >= 1; j--){
				
				if(a[i] > a[j]){
					d[i] = Math.max(d[i], d[j] + a[i]);
				}
				
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= N; i++){
			
			if(max < d[i]) max = d[i];
		}
		System.out.println(max);
		
	}

}
