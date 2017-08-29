import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 8. 29..
 * problem : https://www.acmicpc.net/problem/1966
 */
public class Printer_queue {

	static class document implements Comparable<document>{
		int level;
		boolean find;
		document(int level){
			this.level = level;
		}
		public void setFind(){
			this.find = true;
		}
		@Override
		public int compareTo(document o) {
			// TODO Auto-generated method stub
			return -Integer.compare(this.level, o.level);
		}
		
		
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			PriorityQueue<document> pq = new PriorityQueue<>();
			for(int i=0;i<N;i++){
				int input = sc.nextInt();
				document d = new document(input);
				if(i == M){
					d.setFind();
				}
				pq.add(d);
			}
			System.out.println("get");
			int index = 1;
			while( !pq.isEmpty() ){
				
				document a = pq.remove();
				if(a.find){
					System.out.println(index);
					break;
				}
				index++;
				
			}
			
		}
		
	}
}
