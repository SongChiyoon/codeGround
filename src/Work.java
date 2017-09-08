import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/* Created by songchiyun on 2017. 9. 9..
 * problem : https://www.acmicpc.net/problem/2056
 */
public class Work {

	static class work{
		private int cost;
		int degree;
		int arrive;
		int time;
		List<edge> edgeList;
		work(){
			this.degree = 0;
			this.arrive = Integer.MIN_VALUE;
			edgeList = new LinkedList<>();	
		}
		public void setCost(int c){
			this.cost = c;
		}
		public void addEdge(edge e){
			this.edgeList.add(e);
		}
	}
	static class edge{
		int t;
		edge(int t){
			this.t= t;
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		work[] d = new work[N+1];
		for(int i=1;i<=N;i++)
			d[i] = new work();

		for(int i=1;i<=N;i++){
			int cost = sc.nextInt();
			int num = sc.nextInt();
			d[i].setCost(cost);
			
			for(int j=0;j<num;j++){
			
				int t = sc.nextInt();
				d[t].addEdge(new edge(i));
				d[i].degree++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		for(int i=1;i<=N;i++){
			
			if(d[i].degree == 0){
				d[i].arrive = 0;
				q.add(i);
			}		
		}
		while( !q.isEmpty() ){
			
			int a = q.remove();
			result.add(a);
			for(edge e : d[a].edgeList){
				d[e.t].degree--;
				d[e.t].arrive = Math.max(d[a].arrive + d[a].cost, d[e.t].arrive);

				if(d[e.t].degree==0){
					q.add(e.t);
				}
			}
		}
		int ans = 0;
		for(int i=1;i<=N;i++)
			ans = Math.max(d[i].arrive+d[i].cost, ans);
		System.out.println(ans);
	}
}
