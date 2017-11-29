/*
 * problem : https://www.acmicpc.net/problem/2490
 */
import java.util.*;
public class StickPlaying {

	public static void main(String[] args) {
		
		char[] result = {'E','A','B','C','D'};
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<3;i++) {
			int ans = 0;
			for(int j=0;j<4;j++) {
				int state = sc.nextInt();
				if(state == 0)
					ans++;
				
			}
			System.out.println(result[ans]);
			
		}
	}
}
