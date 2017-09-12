import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/* Created by songchiyun on 2017. 9. 12..
 * problem : https://www.acmicpc.net/problem/11779
 */
public class minimum_cost2 {

	static class node implements Comparable<node>{
		List<edge> edgeList;
		int cost;
		int name;
		node(int name){
			this.name = name;
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
		int[] back = new int[n+1];
		int[] c = new int[n+1];
		for(int i=1;i<=n;i++)
			d[i] = new node(i);
		for(int i=0;i<m;i++){
			int s = sc.nextInt();
			int t = sc.nextInt();
			int cost = sc.nextInt();
			d[s].addEdge(new edge(t, cost));
		}
		int source = sc.nextInt();
		int target = sc.nextInt();
		d[source].cost = 0;
		back[source] = -1;
		c[source] = 1;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(d[source]);
		while( !pq.isEmpty() ){
			
			node a = pq.remove();
			for(edge e : a.edgeList){
				
				if(d[e.t].cost > a.cost + e.cost ){
					d[e.t].cost = a.cost+e.cost;
					c[e.t] = c[a.name]+1;
					back[e.t] = a.name; 
					pq.add(d[e.t]);
				}
				
			}
		}
		System.out.println(d[target].cost);
		int b = target;
		System.out.println(c[target]);
		Stack<Integer> ans = new Stack<>();
		while(b != -1){
			ans.add(b);
			b = back[b];	
		}
		while(!ans.isEmpty()){
			int a = ans.pop();
			System.out.print(a+" ");
		}
	}
}
