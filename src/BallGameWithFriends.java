/*
 * problem : https://www.acmicpc.net/problem/1592
 */
import java.util.*;
public class BallGameWithFriends {

	public static void main(String[] args){
		
		int N, M, L;
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		int[] count = new int[N+1];
		int ball = 1;
		int ans = 0;
		while(true){

			count[ball] += 1;
			if(count[ball] >= M){
				System.out.println(ans);
				break;
			}
			if(count[ball] % 2 ==0){
				
				if(ball+L <= N){
					ball += L;
				}
				else
					ball = (ball + L) % N;  
			}
			else{
				if(ball-L > 0)
					ball -= L;
				else
					ball = N+(ball-L);
			}

			ans++;
			


		}
	}
}
