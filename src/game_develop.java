import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/* Created by songchiyun on 2017. 9. 9..
 * problem : https://www.acmicpc.net/problem/1516
 */
public class game_develop {

	static class building{
		int degree;
		int cost;
		int arrive;
		List<edge> edgeList;
		building(){
			degree = 0;
			this.arrive = Integer.MIN_VALUE;
			edgeList = new LinkedList<>();
		}
		public void addEdge(edge e){
			edgeList.add(e);
		}
	}
	static class edge{
		int t;
		edge(int t){
			this.t=t;
		}
	}
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		building[] d = new building[N+1];
		for(int i=1;i<=N;i++)
			d[i] = new building();
		for(int i=1;i<=N;i++){
			int cost = sc.nextInt();
			d[i].cost = cost;
			while(true){
				int e = sc.nextInt();
				if(e == -1)
					break;
				d[e].addEdge(new edge(i));
				d[i].degree++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		
		for(int i=1;i<=N;i++){
			if(d[i].degree == 0){
				q.add(i);
				d[i].arrive = 0;
			}
		}
		while( !q.isEmpty() ){
			
			int a = q.remove();
			result.add(a);
			for(edge e : d[a].edgeList){
				d[e.t].degree--;
				d[e.t].arrive = Math.max(d[e.t].arrive, d[a].arrive + d[a].cost);
				if(d[e.t].degree == 0)
					q.add(e.t);
			}
		}
		int ans = 0;
		for(int i=1;i<=N;i++){
			System.out.println(d[i].arrive+d[i].cost);
			ans = Math.max(ans, d[i].arrive+d[i].cost);
		}
		//System.out.println(ans);
	}
}
