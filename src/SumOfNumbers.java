/*
 * https://www.acmicpc.net/problem/1789
 */
import java.util.*;
public class SumOfNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long sum = sc.nextLong();
		
		long cnt=0;
		long temp=0;
		int num = 1;
		while(true){
			if(temp == sum)
				break;
			else if(temp > sum) {
				cnt--;
				break;
			}
			else {
				temp += num;
				num++;
				cnt++;
			}
			
		}
		System.out.println(cnt);
		
	}
}
