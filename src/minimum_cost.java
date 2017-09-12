import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/* Created by songchiyun on 2017. 9. 10..
 * problem : https://www.acmicpc.net/problem/1197
 */
public class minimum_cost {

	static class node implements Comparable<node>{
		List<edge> edgeList;
		int cost;
		node(){
			edgeList = new LinkedList<>();
			this.cost = Integer.MAX_VALUE;
		}
		public void addEdge(edge e){
			this.edgeList.add(e);
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	static class edge{
		int t;
		int cost;
		edge(int t, int cost){
			this.t= t;
			this.cost= cost;
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		node[] d = new node[n+1];
		for(int i=1;i<=n;i++)
			d[i] = new node();
		for(int i=0;i<m;i++){
			int s = sc.nextInt();
			int t = sc.nextInt();
			int cost = sc.nextInt();
			d[s].addEdge(new edge(t, cost));
		}
		int source = sc.nextInt();
		int target = sc.nextInt();
		d[source].cost = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(d[source]);
		while( !pq.isEmpty() ){
			
			node a = pq.remove();
			for(edge e : a.edgeList){
				
				if(d[e.t].cost > a.cost + e.cost ){
					d[e.t].cost = a.cost+e.cost;
					pq.add(d[e.t]);
				}
				
			}
		}
		System.out.println(d[target].cost);
		
	}
}
