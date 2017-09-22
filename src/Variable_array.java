import java.util.Arrays;
import java.util.Scanner;


/**
	 * Created by songchiyun on 2017. 9. 22..
	 * problem : https://www.acmicpc.net/problem/1551
	 */
public class Variable_array {

	//B[i] = a[i+1]-a[i]
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int K = sc.nextInt();
		int[] d = new int[N];
		String input = sc.next();
		String[] inputs = input.split(",");

		for(int i=0;i<N;i++)
		{
			d[i] = Integer.parseInt(inputs[i]);
		}
		
		if(K == 0){
			for(int i=0;i<N;i++){
				System.out.print(d[i]);
				if(i != N-1)
					System.out.print(",");
			}
		}
		int[] b = new int[N];
		for(int k=0;k<K;k++){
			
			for(int i=1+k;i<N;i++){
				b[i] = d[i] -d[i-1];
			}
			for(int i=0;i<N;i++)
				d[i] = b[i];
		}
		for(int i=K;i<N;i++){
			System.out.print(b[i]);
			if(i != N-1)
				System.out.print(",");
		}
				
	}
}
