import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/* Created by songchiyun on 2017. 9. 10..
 * problem : https://www.acmicpc.net/problem/1922
 */
public class connect_Network {

	static class com{
		List<net> netList;
		com(){
			netList = new LinkedList<>();
		}
		public void addNet(net e){
			this.netList.add(e);
		}
	}
	static class net implements Comparable<net>
	{
		int s, t;
		int cost;
		net(int s, int t, int cost){
			this.s = s;
			this.t= t;
			this.cost = cost;
		}
		@Override
		public int compareTo(net o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] v = new boolean[N+1];
		com[] d = new com[N+1];
		for(int i=1;i<=N;i++)
			d[i] = new com();
		
		int M = sc.nextInt();
		PriorityQueue<net> pq = new PriorityQueue<>();
		
		for(int i=0;i<M;i++){
			
			int s = sc.nextInt();
			int t= sc.nextInt();
			int cost = sc.nextInt();
			d[s].addNet(new net(s,t,cost));
			d[t].addNet(new net(t,s,cost));
		}
		int start = 1;
		v[start] = true;
		
		List<Integer> result = new LinkedList<>();
		for(net e : d[start].netList)
			pq.add(e);
		while( !pq.isEmpty() ){
			net a = pq.remove();
			if( !v[a.t] ){
				v[a.t] = true;
				result.add(a.cost);
				for(net e : d[a.t].netList)
					pq.add(e);
			}
		}
		int ans = 0;
		for(int e : result)
			ans += e;
		System.out.println(ans);
	}
}
