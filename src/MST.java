import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/* Created by songchiyun on 2017. 9. 10..
 * problem : https://www.acmicpc.net/problem/1197
 */
public class MST {

	static class node{
		List<edge> edgeList;
		node(){
			edgeList = new LinkedList<>();
		}
		public void addEdge(edge e){
			this.edgeList.add(e);
		}
	}
	static class edge implements Comparable<edge>{
		int t, cost;
		edge(int t, int cost){
			this.t= t;
			this.cost = cost;
		}
		@Override
		public int compareTo(edge arg0) {
			// TODO Auto-generated method stub
			return -Integer.compare(this.cost, arg0.cost);
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		node[] d = new node[N+1];
		boolean[] v = new boolean[N+1];
		for(int i=1;i<=N;i++)
			d[i] = new node();
		int M = sc.nextInt();
		for(int i=0;i<M;i++)
		{
			int s = sc.nextInt();
			int t= sc.nextInt();
			int cost = sc.nextInt();
			d[s].addEdge(new edge(t, cost));
			d[t].addEdge(new edge(s, cost));
		}
		PriorityQueue<edge> pq = new PriorityQueue<>();
		int source = 1;
		v[source] = true;
		List<Integer> result = new LinkedList<>();
		for(edge e : d[source].edgeList)
			pq.add(e);
		while( !pq.isEmpty() ){
			edge a = pq.remove();
			if( !v[a.t] ){
				result.add(a.cost);
				v[a.t] = true;
				for(edge e : d[a.t].edgeList)
					pq.add(e);
			}
		}
		int ans = 0;
		for(int a : result)
			ans += a;
		System.out.println(ans);
	}
}
