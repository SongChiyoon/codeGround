import java.util.Scanner;
/*
 * Created by songchiyun on 2017. 7. 22..
 * https://www.acmicpc.net/problem/11047
 */
public class Coin0 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] c = new int[N];
		for(int i=0;i<N;i++){
			c[i] = sc.nextInt();
		}
		int answer = 0;
		for(int i=N-1; i>=0; i--){
			
			if(K >= c[i]){
				int n=K/c[i];
				K -= n*c[i];
				answer += n;
				if(K==0){
					break;
				}
			}
			
		}
		System.out.println(answer);
	}

}
