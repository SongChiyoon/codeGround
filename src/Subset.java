import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 22..
 * problem : https://www.acmicpc.net/problem/1182
 */
public class Subset {

	static int[] d;
	static int S;
	static int N;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		d = new int[N];
		for(int i=0;i<N;i++)
			d[i] = sc.nextInt();
		ans =0;
		
		for(int i=0;i<N;i++){
			subset(i, d[i], false);
		}
		System.out.println(ans);
	}
	static int ans;
	static void subset(int k, int total, boolean skip){

		if(k >= N)
			return;
		if(!skip){
			if(total == S){
				ans++;
			}
		}
			
		if(k < N-1){
			subset(k+1, total+d[k+1], false);
			subset(k+1, total, true);
		}
		
		
	}
}
