import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 19..
 * https://www.acmicpc.net/problem/2455
 */
public class smart_Train {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<4;i++){
			sum -= sc.nextInt();
			sum += sc.nextInt();
			max = Math.max(sum, max);
			
		}
		System.out.println(max);
	}
}
