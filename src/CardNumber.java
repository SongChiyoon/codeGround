import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 7. 24..
 * https://www.acmicpc.net/problem/10815
 */
public class CardNumber {

	static int[] c;
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		c = new int[N];
		for(int i=0;i<N;i++){
			c[i] = sc.nextInt();
		}
		Arrays.sort(c);
	
		int M = sc.nextInt();
		StringBuilder ans = new StringBuilder();

		for(int i=0;i<M;i++){
			int num = sc.nextInt();
			if(find(num) == 1){
				ans.append("1 ");
			}
			else{
				ans.append("0 ");
			}
		}

		System.out.println(ans);
	}

	public static int find(int x){
		int left = 0;
		int right = c.length-1;
		while(left <= right){
			int m = (left+right)/2;
			System.out.println("mid "+m);
			if(c[m] == x){
				return 1;
			}
			else if(c[m] < x){
				left = m+1;
			}
			else{
				right = m-1;
			}
		}
		return 0;
		
	}
}
