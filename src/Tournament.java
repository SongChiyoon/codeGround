import java.util.Scanner;
/**
 * Created by songchiyun on 2017. 8. 19..
 * https://www.acmicpc.net/problem/1057
 */
public class Tournament {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a > b){
			int temp = a;
			a = b;
			b = temp;
		}
		int count = 1;

		while(true){
			if(b%2==0 && b-1 == a){
				break;
			}
			if(b%2!=0){
				b = b/2+1;
			}
			else{
				b /=2; 
			}
			if(a%2!=0)
				a = a/2+1;
			else
				a/=2;

			count++;				
		}
		System.out.println(count);
	}
}
