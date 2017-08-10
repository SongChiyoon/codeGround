import java.util.*;

/**
 * Created by songchiyun on 2017. 8. 10..
 * 문제 : https://www.acmicpc.net/problem/1260
 */
public class BFS_DFS {

    static class node{
        private PriorityQueue<edge> edgeList;
        private PriorityQueue<edge> edgeList_bfs;

        int name;
        node(int name){
            this.name = name;
            edgeList = new PriorityQueue<>();
            edgeList_bfs = new PriorityQueue<>();;
        }
        public void addEdge(edge e){
            this.edgeList.add(e);
        }
        public void addEdge_bfs(edge e){
            this.edgeList_bfs.add(e);
        }
        public PriorityQueue<edge> getEdgeList(){return this.edgeList;}
        public PriorityQueue<edge> getEdgeList_bfs(){return this.edgeList_bfs;}
    }
    static class edge implements Comparable<edge>{
        int source;
        int target;
        edge(int s, int t){
            this.source = s;
            this.target = t;
        }

        @Override
        public int compareTo(edge other) {
            return Integer.compare(this.target, other.target);
        }
    }

    static node[] d;

    static boolean[] dfs_v, bfs_v;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        d = new node[N+1];

        for(int i=1;i<=N;i++){
            d[i] = new node(i);
        }
        dfs_v = new boolean[N+1];
        bfs_v = new boolean[N+1];

        int M = sc.nextInt();
        int source = sc.nextInt();

        for(int i=0;i<M;i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            d[s].addEdge(new edge(s, t));
            d[s].addEdge_bfs(new edge(s, t));
            d[t].addEdge(new edge(t, s));
            d[t].addEdge_bfs(new edge(t, s));
        }

        dfs(source);
        System.out.println();

        Queue<node> q = new LinkedList<>();

        q.add(d[source]);

        System.out.print(source+" ");

        bfs_v[source]=true;

        while( !q.isEmpty() ){

            node active = q.remove();
            PriorityQueue<edge> pq = active.getEdgeList_bfs();

            while( !pq.isEmpty() ){
                edge e = pq.remove();
                if(!bfs_v[e.target]){
                    q.add(d[e.target]);
                    bfs_v[e.target]=true;
                    System.out.print(e.target+" ");
                }
            }
        }

    }
    static void dfs(int current){
        dfs_v[current]=true;
        System.out.print(current+" ");
        PriorityQueue<edge> pq = d[current].getEdgeList();
        while( !pq.isEmpty() ){
            edge e = pq.remove();
            if(!dfs_v[e.target])
            {
                dfs(e.target);
            }
        }
    }
}
