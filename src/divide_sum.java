	import java.util.Scanner;
	
	/**
	 * Created by songchiyun on 2017. 9. 22..
	 * problem : https://www.acmicpc.net/problem/2231
	 */
	public class divide_sum {
	
		public static void main(String[] args){
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			for(int i=1;i<N;i++){
				
				if(go(i) == N)
				{
					System.out.println(i);
					return;
				}
				
			}
			System.out.println(0);
		}
		static int go(int N){
			int sum = N;
			while(N > 0) {
				sum += N %10;
				N /= 10;
				
			}
			return sum;
		}
	}
