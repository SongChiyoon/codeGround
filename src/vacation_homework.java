import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 29..
 * problem : https://www.acmicpc.net/problem/5532
 */
public class vacation_homework {
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int A = sc.nextInt(); //����
		int B = sc.nextInt(); //����
		int c = sc.nextInt();  //�ִ� ����
		int d = sc.nextInt(); //�ִ� ����
		
		int ans = L;
		while( ans >=0 ){
			ans--;
			if(A >= 0)
				A -= c;
			if(B >= 0)
				B -= d;
			if(A <= 0 && B <= 0)
				break;
		}
		System.out.println(ans);
	}
}
