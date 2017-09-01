import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by songchiyun on 2017. 9. 1..
 * problem : https://www.acmicpc.net/problem/1967
 */
public class tree_diameter {

    static class node{

        int name;
        List<edge> edgeList;
        int length;
        node(int name){
            this.name = name;
            length = 0;
            edgeList = new LinkedList<>();
        }
        public void addEdge(edge e){
            this.edgeList.add(e);
        }
        public List<edge> getEdgeList(){
            return this.edgeList;
        }
    }
    static class edge{
        int parent;
        int child;
        int weight;
        edge(int parent, int child, int weight){
            this.parent = parent;
            this.child = child;
            this.weight = weight;
        }
    }
    static node[] d;
    static int[] added;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        added = new int[N+1];
        d = new node[N+1];
        for(int i=1;i<=N;i++)
            d[i] = new node(i);
        for(int i=0;i<N-1;i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            int w = sc.nextInt();
            d[p].addEdge(new edge(p, c, w));
        }
        for(edge e : d[1].getEdgeList()){
            dfs(e.child, e.weight); 
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++){
            int sum = 0;
            int max1 = -1;
            int max2 = -1;
            for(edge e : d[i].getEdgeList()){
            	
                int compare = d[e.child].length;

                if(max1 == -1)
                    max1 = compare;
                
                else if(max2 == -1){
                    if(compare > max1){
                    	max2 = max1;
                    	max1 = compare;
                    }
                    else{
                    	max2 = compare;
                    }
                }

                else{
                    if(compare > max1){
                        max2 = max1;
                        max1 = compare;
                    }
                    else if(compare > max2)
                        max2 = compare;
                }
            }
            if(max2 == -1)
                sum = max1;
            else
                sum += (max1 + max2);

            if(max < sum){
                max = sum;
            }
        }

        System.out.println(max);

    }
    public static void dfs(int current, int weight){

        if(d[current].edgeList.size() == 0){  //맨밑
            d[current].length = weight;
            return;
        }
        for(edge e : d[current].getEdgeList()){

            dfs(e.child, e.weight);
            d[current].length = Math.max(d[e.child].length + weight, d[current].length);

        }

    }
}
