import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sumba {
	public static void main(String[] args){
		int max = 100001;
		
		int[] count = new int[max];
		Queue<Integer> q = new LinkedList<>();
		int N, K;
		Scanner sc = new Scanner(System.in);
		do{
			N = sc.nextInt();
		}while(N < 0 || N > max);
		do{
			K = sc.nextInt();
		}while(K < 0 || K > max);
		sc.close();
		if(N == K){
			System.out.println(0);
			return;
		}
		q.add(N);
		count[N] = 0;
		
		while(!q.isEmpty()){
			int currentNode = q.remove();
			if(currentNode+1 <= 100000 && count[currentNode+1] == 0){
				q.add(currentNode+1);
				count[currentNode+1] = count[currentNode] + 1;
			}
			if(currentNode-1 >= 0 && count[currentNode-1] == 0){
				q.add(currentNode-1);
				count[currentNode-1] = count[currentNode] + 1;
			}
			if(currentNode*2 <= 100000 && count[2*currentNode] == 0){
				q.add(2*currentNode);
				count[2*currentNode] = count[currentNode] + 1;
			}	
		}
		System.out.println(count[K]);
	}
}
