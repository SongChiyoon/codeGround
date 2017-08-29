import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 29..
 * problem : https://www.acmicpc.net/problem/2164
 */
public class Card2 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 1){
			System.out.println(1);
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++)
			q.add(i);
		int ans = -1;
		do{
			q.remove();
			if(q.isEmpty())
				break;
			ans = q.remove();
			q.add(ans);
		}while( !q.isEmpty() );
		System.out.println(ans);
	}
}
